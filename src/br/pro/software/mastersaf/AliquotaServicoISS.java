package br.pro.software.mastersaf;

public class AliquotaServicoISS {
	/*
	 * E que as alíquotas de acordo com os códigos de serviços são:
	 * Código / Alíquota
	 *   1001 / 5%
	 *   1002 / 5%
	 *   1003 / 5%
	 *   2001 / 3%
	 *   2002 / 4%
	 */
	/**
	 * Devolve a alíquota de imposto de renda baseado no código de serviço do INSS.
	 */
	public static double getAliquota(int codigoServico) {
		double porcent = 0;
		switch (codigoServico) {
			case 1001:
			case 1002:
			case 1003: porcent = 5; break;
			case 2001: porcent = 3; break;
			case 2002: porcent = 4; break;
		}
		return porcent/100;
	}
}
