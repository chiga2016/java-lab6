//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.24 at 05:34:11 PM YEKT 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="2">
 *         &lt;element name="bound" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="origin" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}user"/>
 *         &lt;element ref="{}preferences"/>
 *         &lt;element ref="{}gpx_file"/>
 *         &lt;element ref="{}api"/>
 *         &lt;element ref="{}changeset"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}node"/>
 *           &lt;element ref="{}way"/>
 *           &lt;element ref="{}relation"/>
 *         &lt;/choice>
 *       &lt;/choice>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}float" fixed="0.6" />
 *       &lt;attribute name="generator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="copyright" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attribution" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="license" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "boundOrUserOrPreferences"
})
@XmlRootElement(name = "osm")
public class Osm {

    @XmlElements({
        @XmlElement(name = "bound", type = Osm.Bound.class),
        @XmlElement(name = "user", type = User.class),
        @XmlElement(name = "preferences", type = Preferences.class),
        @XmlElement(name = "gpx_file", type = GpxFile.class),
        @XmlElement(name = "api", type = Api.class),
        @XmlElement(name = "changeset", type = Changeset.class),
        @XmlElement(name = "node", type = Node.class),
        @XmlElement(name = "way", type = Way.class),
        @XmlElement(name = "relation", type = Relation.class)
    })
    protected List<Object> boundOrUserOrPreferences;
    @XmlAttribute(name = "version", required = true)
    protected float version;
    @XmlAttribute(name = "generator")
    protected String generator;
    @XmlAttribute(name = "copyright", required = true)
    protected String copyright;
    @XmlAttribute(name = "attribution", required = true)
    protected String attribution;
    @XmlAttribute(name = "license", required = true)
    protected String license;

    /**
     * Gets the value of the boundOrUserOrPreferences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundOrUserOrPreferences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundOrUserOrPreferences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Osm.Bound }
     * {@link User }
     * {@link Preferences }
     * {@link GpxFile }
     * {@link Api }
     * {@link Changeset }
     * {@link Node }
     * {@link Way }
     * {@link Relation }
     * 
     * 
     */
    public List<Object> getBoundOrUserOrPreferences() {
        if (boundOrUserOrPreferences == null) {
            boundOrUserOrPreferences = new ArrayList<Object>();
        }
        return this.boundOrUserOrPreferences;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public float getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(float value) {
        this.version = value;
    }

    /**
     * Gets the value of the generator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerator() {
        return generator;
    }

    /**
     * Sets the value of the generator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerator(String value) {
        this.generator = value;
    }

    /**
     * Gets the value of the copyright property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets the value of the copyright property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyright(String value) {
        this.copyright = value;
    }

    /**
     * Gets the value of the attribution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribution() {
        return attribution;
    }

    /**
     * Sets the value of the attribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribution(String value) {
        this.attribution = value;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicense(String value) {
        this.license = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="box" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="origin" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bound {

        @XmlAttribute(name = "box")
        protected String box;
        @XmlAttribute(name = "origin")
        @XmlSchemaType(name = "anyURI")
        protected String origin;

        /**
         * Gets the value of the box property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBox() {
            return box;
        }

        /**
         * Sets the value of the box property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBox(String value) {
            this.box = value;
        }

        /**
         * Gets the value of the origin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

    }

}
