@XmlRootElement(name = "Roomtype")
@XmlAccessorType(XmlAccessType.FIELD)
public class Roomtype {
    . . .
    @XmlAttribute(name="EUR")
    @XmlElement(name = "TotalTaxesAndFees")
    private double totalTaxesAndFees;