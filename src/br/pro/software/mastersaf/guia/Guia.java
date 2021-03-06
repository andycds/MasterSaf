//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.11 at 01:11:45 PM BRT 
//


package br.pro.software.mastersaf.guia;

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
 *         &lt;element ref="{}data_recolhimento"/>
 *         &lt;element ref="{}valor_iss"/>
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
    "dataRecolhimento",
    "valorIss"
})
@XmlRootElement(name = "guia")
public class Guia {

    @XmlElement(name = "emitente_cnpj", required = true)
    protected BigInteger emitenteCnpj;
    @XmlElement(name = "data_recolhimento", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String dataRecolhimento;
    @XmlElement(name = "valor_iss", required = true)
    protected BigDecimal valorIss;

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
     * Gets the value of the dataRecolhimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRecolhimento() {
        return dataRecolhimento;
    }

    /**
     * Sets the value of the dataRecolhimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRecolhimento(String value) {
        this.dataRecolhimento = value;
    }

    /**
     * Gets the value of the valorIss property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorIss() {
        return valorIss;
    }

    /**
     * Sets the value of the valorIss property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorIss(BigDecimal value) {
        this.valorIss = value;
    }

}
