//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.10 at 11:06:07 PM BRT 
//


package br.pro.software.mastersaf.nota;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmitenteCnpj_QNAME = new QName("", "emitente_cnpj");
    private final static QName _ValorTotal_QNAME = new QName("", "valor_total");
    private final static QName _DataEmissao_QNAME = new QName("", "data_emissao");
    private final static QName _CodigoServico_QNAME = new QName("", "codigo_servico");
    private final static QName _Numero_QNAME = new QName("", "numero");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Nota }
     * 
     */
    public Nota createNota() {
        return new Nota();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "emitente_cnpj")
    public JAXBElement<BigInteger> createEmitenteCnpj(BigInteger value) {
        return new JAXBElement<BigInteger>(_EmitenteCnpj_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "valor_total")
    public JAXBElement<BigDecimal> createValorTotal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ValorTotal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "data_emissao")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDataEmissao(String value) {
        return new JAXBElement<String>(_DataEmissao_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codigo_servico")
    public JAXBElement<BigInteger> createCodigoServico(BigInteger value) {
        return new JAXBElement<BigInteger>(_CodigoServico_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "numero")
    public JAXBElement<BigInteger> createNumero(BigInteger value) {
        return new JAXBElement<BigInteger>(_Numero_QNAME, BigInteger.class, null, value);
    }

}
