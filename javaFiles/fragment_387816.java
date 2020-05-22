@XmlAccessorType(XmlAccessType.FIELD)
public class Total {
    @XmlAttribute(name = "currency")
    private String currency;
    @XmlAttribute(name = "EUR")
    private double eur;
    @XmlValue
    private double total;
}