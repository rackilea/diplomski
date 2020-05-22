@XmlAccessorType(XmlAccessType.FIELD)
public class Roomtype {
    @XmlElement(name = "Roomid")
    private Roomid roomid;
    . . .
    @XmlElement(name = "Totalrate")
    private Total totalrate;
    @XmlElement(name = "TotalTaxesAndFees")
    private Total totalTaxesAndFees;
    @XmlElement(name = "TotalChargeable")
    private Total totalChargeable;
    @XmlElement(name = "Reckratetotal")
    private Total reckratetotal;