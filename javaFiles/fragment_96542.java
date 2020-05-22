@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestSource",
    "requestCode",
    "dataSet"
})
@XmlRootElement(name = "CRMMessage")
public class CRMMessage {

    @XmlElement(name = "RequestSource", required = true)
    protected CRMMessage.RequestSource requestSource;
    @XmlElement(name = "RequestCode", required = true)
    protected String requestCode;
    @XmlElement(name = "DataSet", required = true)
    protected CRMMessage.DataSet dataSet;
    @XmlAttribute(name = "language")
    protected String language;
    @XmlAttribute(name = "currency")
    protected String currency;

    /**
     * Gets the value of the requestSource property.
     * 
     * @return
     *     possible object is
     *     {@link CRMMessage.RequestSource }
     *     
     */
    public CRMMessage.RequestSource getRequestSource() {
        return requestSource;
    }

    /**
     * Sets the value of the requestSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRMMessage.RequestSource }
     *     
     */
    public void setRequestSource(CRMMessage.RequestSource value) {
        this.requestSource = value;
    }

    /**
     * Gets the value of the requestCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestCode() {
        return requestCode;
    }

    /**
     * Sets the value of the requestCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestCode(String value) {
        this.requestCode = value;
    }

    /**
     * Gets the value of the dataSet property.
     * 
     * @return
     *     possible object is
     *     {@link CRMMessage.DataSet }
     *     
     */
    public CRMMessage.DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRMMessage.DataSet }
     *     
     */
    public void setDataSet(CRMMessage.DataSet value) {
        this.dataSet = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
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
     *       &lt;all>
     *         &lt;element name="DataSetColumns">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DSColumn" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Rows">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Row" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Col" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class DataSet {

        @XmlElement(name = "DataSetColumns", required = true)
        protected CRMMessage.DataSet.DataSetColumns dataSetColumns;
        @XmlElement(name = "Rows", required = true)
        protected CRMMessage.DataSet.Rows rows;

        /**
         * Gets the value of the dataSetColumns property.
         * 
         * @return
         *     possible object is
         *     {@link CRMMessage.DataSet.DataSetColumns }
         *     
         */
        public CRMMessage.DataSet.DataSetColumns getDataSetColumns() {
            return dataSetColumns;
        }

        /**
         * Sets the value of the dataSetColumns property.
         * 
         * @param value
         *     allowed object is
         *     {@link CRMMessage.DataSet.DataSetColumns }
         *     
         */
        public void setDataSetColumns(CRMMessage.DataSet.DataSetColumns value) {
            this.dataSetColumns = value;
        }

        /**
         * Gets the value of the rows property.
         * 
         * @return
         *     possible object is
         *     {@link CRMMessage.DataSet.Rows }
         *     
         */
        public CRMMessage.DataSet.Rows getRows() {
            return rows;
        }

        /**
         * Sets the value of the rows property.
         * 
         * @param value
         *     allowed object is
         *     {@link CRMMessage.DataSet.Rows }
         *     
         */
        public void setRows(CRMMessage.DataSet.Rows value) {
            this.rows = value;
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
         *       &lt;sequence>
         *         &lt;element name="DSColumn" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "dsColumn"
        })
        public static class DataSetColumns {

            @XmlElement(name = "DSColumn", required = true)
            protected List<CRMMessage.DataSet.DataSetColumns.DSColumn> dsColumn;

            /**
             * Gets the value of the dsColumn property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the dsColumn property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDSColumn().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CRMMessage.DataSet.DataSetColumns.DSColumn }
             * 
             * 
             */
            public List<CRMMessage.DataSet.DataSetColumns.DSColumn> getDSColumn() {
                if (dsColumn == null) {
                    dsColumn = new ArrayList<CRMMessage.DataSet.DataSetColumns.DSColumn>();
                }
                return this.dsColumn;
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
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class DSColumn {

                @XmlAttribute(name = "name")
                protected String name;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

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
         *       &lt;sequence>
         *         &lt;element name="Row" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Col" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "row"
        })
        public static class Rows {

            @XmlElement(name = "Row", required = true)
            protected List<CRMMessage.DataSet.Rows.Row> row;

            /**
             * Gets the value of the row property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the row property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRow().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CRMMessage.DataSet.Rows.Row }
             * 
             * 
             */
            public List<CRMMessage.DataSet.Rows.Row> getRow() {
                if (row == null) {
                    row = new ArrayList<CRMMessage.DataSet.Rows.Row>();
                }
                return this.row;
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
             *       &lt;sequence>
             *         &lt;element name="Col" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
                "col"
            })
            public static class Row {

                @XmlElement(name = "Col", required = true)
                protected List<String> col;

                /**
                 * Gets the value of the col property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the col property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCol().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * 
                 * 
                 */
                public List<String> getCol() {
                    if (col == null) {
                        col = new ArrayList<String>();
                    }
                    return this.col;
                }

            }

        }

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
     *       &lt;attribute name="Testsource" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RequestSource {

        @XmlAttribute(name = "Testsource")
        protected String testsource;
        @XmlAttribute(name = "version")
        protected BigInteger version;

        /**
         * Gets the value of the testsource property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTestsource() {
            return testsource;
        }

        /**
         * Sets the value of the testsource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTestsource(String value) {
            this.testsource = value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setVersion(BigInteger value) {
            this.version = value;
        }

    }

}