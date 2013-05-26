//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.10 at 11:06:07 PM BRT 
//


package br.pro.software.mastersaf.nota;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}emitente_cnpj"/>
 *         &lt;element ref="{}numero"/>
 *         &lt;element ref="{}data_emissao"/>
 *         &lt;element ref="{}codigo_servico"/>
 *         &lt;element ref="{}valor_total"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "emitenteCnpj",
    "numero",
    "dataEmissao",
    "codigoServico",
    "valorTotal"
})
@XmlRootElement(name = "nota")
public class Nota {

    @XmlElement(name = "emitente_cnpj", required = true)
    protected BigInteger emitenteCnpj;
    @XmlElement(required = true)
    protected BigInteger numero;
    @XmlElement(name = "data_emissao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String dataEmissao;
    @XmlElement(name = "codigo_servico", required = true)
    protected BigInteger codigoServico;
    @XmlElement(name = "valor_total", required = true)
    protected BigDecimal valorTotal;

    /**
     * Gets the value of the emitenteCnpj property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEmitenteCnpj() {
        return emitenteCnpj;
    }

    /**
     * Sets the value of the emitenteCnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEmitenteCnpj(BigInteger value) {
        this.emitenteCnpj = value;
    }

    /**
     * Gets the value of the numero property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumero(BigInteger value) {
        this.numero = value;
    }

    /**
     * Gets the value of the dataEmissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEmissao() {
        return dataEmissao;
    }

    /**
     * Sets the value of the dataEmissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEmissao(String value) {
        this.dataEmissao = value;
    }

    /**
     * Gets the value of the codigoServico property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodigoServico() {
        return codigoServico;
    }

    /**
     * Sets the value of the codigoServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigoServico(BigInteger value) {
        this.codigoServico = value;
    }

    /**
     * Gets the value of the valorTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * Sets the value of the valorTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorTotal(BigDecimal value) {
        this.valorTotal = value;
    }

}
