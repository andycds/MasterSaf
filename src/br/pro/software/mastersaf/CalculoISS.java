package br.pro.software.mastersaf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.pro.software.mastersaf.guia.Guia;
import br.pro.software.mastersaf.nota.Nota;

/*
 * Bibliotecas usadas:
 *  JAXB: xsd -> java
 *  Trang: xml -> xsd
 */

public class CalculoISS {
	/*
	 * <nota>
     *    <emitente_cnpj></emitente_cnpj>
     *    <numero>1</numero>
     *    <data_emissao>2009-03-06</data_emissao>
     *    <codigo_servico>1001</codigo_servico>
     *    <valor_total>500.00</valor_total>
	 * </nota>
	 *
	 * Pedimos que faça um programa e que calcule os valores a serem arrecadados em cada mês por 
	 * emitente a partir de dos dados de notas fiscais que seguem no arquivo em anexo. Você deve
 	 * fornecer o resultado num arquivo XML cuja estrutura fica livre para definir mas que
  	 * contenha claramente identificados os campos <emitente_cnpj>, <data_recolhimento>,
 	 * <valor_iss>. Esse programa pode ser usado por um arrecadador (prefeitura) para emitir
  	 * os guias das empresas e imagine que a cada mês poderá vir um arquivo semelhante para processamento.
	 *
	 */
	HashMap<Arrecadacao, BigDecimal> valorISS = new HashMap<Arrecadacao, BigDecimal>();

	class Arrecadacao {
		public BigInteger emissor;
		public Integer ano;
		public Integer mes;
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Arrecadacao) {
				Arrecadacao outro = (Arrecadacao) obj;
				if (emissor.equals(outro.emissor) && ano.equals(outro.ano) && mes.equals(outro.mes)) return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return emissor.intValue() * 10000 + ano * 10 + mes;
		}
		
		public Arrecadacao(Nota nota) {
			emissor = nota.getEmitenteCnpj();
			ano = new Integer(nota.getDataEmissao().substring(0, 4));
			mes = new Integer(nota.getDataEmissao().substring(5, 7));
		}

		public Guia getGuia(BigDecimal valorISS) {
			Guia guia = new Guia();
			guia.setDataRecolhimento(getDataRecolhimento());
			guia.setEmitenteCnpj(emissor);
			guia.setValorIss(valorISS.setScale(2, BigDecimal.ROUND_HALF_UP));
			return guia;
		}

		private String getDataRecolhimento() {
			StringBuilder data = new StringBuilder();
			if (mes.intValue() == 12) {
				data.append(ano.intValue() + 1);
				data.append("-01");
				
			} else {
				data.append(ano);
				data.append("-");
				if (mes.intValue() < 9) data.append("0");
				data.append(mes.intValue() + 1);
			}
			data.append("-10"); // recolhe-se o ISS no dia 10 do mês seguinte
			return data.toString();
		}
	}
	
	
	private String[] getXMLsFromDir(String directory) {
		File dir = new File(directory);
		String[] children;

		FilenameFilter filter = new FilenameFilter() { 
			public boolean accept(File dir, String name) { 
				return (name.toUpperCase().endsWith("XML") && name.toUpperCase().startsWith("NOTA")); 
			} 
		};

		children = dir.list(filter);
		System.out.println("Arquivos encontrados:");
		for (String arq : children) {
			System.out.println(arq);
		}

		return children;
	}
	
	private void calcularISS(String directory) {
		JAXBContext context;
		Nota nota = null;
		try {
			context = JAXBContext.newInstance(Nota.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			String[] xmls = getXMLsFromDir(directory);
			for (String file : xmls) {
				FileInputStream arq = new FileInputStream(directory + File.separator + file);
				nota = (Nota) unmarshaller.unmarshal(arq);
				Arrecadacao arrecadacao = new Arrecadacao(nota);
				BigDecimal antigoValor = valorISS.get(arrecadacao) == null ? 
						BigDecimal.ZERO : valorISS.get(arrecadacao);
				BigDecimal novoValor = (imposto(nota.getCodigoServico(), nota.getValorTotal())).add(antigoValor);
				System.out.println("");
				System.out.println("emissor: " + nota.getEmitenteCnpj() + " data:" + nota.getDataEmissao());
				System.out.printf("valor: %.2f imposto: %.2f\n", nota.getValorTotal(), imposto(nota.getCodigoServico(), nota.getValorTotal()));
				System.out.printf("valor antigo: %.2f valor novo: %.2f\n", antigoValor, novoValor);
				valorISS.put(arrecadacao, novoValor);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private BigDecimal imposto(BigInteger codigoServico, BigDecimal valor) {
		BigDecimal aliquota = new BigDecimal(AliquotaServicoISS.getAliquota(codigoServico.intValue()));
		return valor.multiply(aliquota);
	}
	
	public void escreverXML() {
		try {
			JAXBContext jc = JAXBContext.newInstance( Guia.class );
			Marshaller m = jc.createMarshaller();
			FileOutputStream fo;
			Guia guia;
			int nGuia = 1;
			for (Arrecadacao arrecadacao : valorISS.keySet()) {
				System.out.print("\nCodigo: " + arrecadacao.emissor + " Ano/Mes: " + arrecadacao.ano + "/" + arrecadacao.mes + " ISS: ");
				System.out.printf("%.02f", valorISS.get(arrecadacao));
				guia = arrecadacao.getGuia(valorISS.get(arrecadacao));
				System.out.println("---");
				fo = new FileOutputStream("guia" + nGuia++ + ".xml");
				m.marshal( guia, fo );
			}
		} catch( JAXBException jbe ){
			jbe.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length >= 1) {
			CalculoISS calculoISS = new CalculoISS();
			calculoISS.calcularISS(args[0]);
			calculoISS.escreverXML();
		} else {
			System.out.println("Passe como argumento um diretorio contendo as notas em formato XML (nota1.xml, nota2.xml).");
		}
	}
}
