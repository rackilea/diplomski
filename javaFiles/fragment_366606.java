@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeType", propOrder = {
    "something1",
    "something2"
})
public class TradeType {
    @XmlElement(name = "Something1")
    protected Something1Type something1;
    @XmlElement(name = "Something2")
    protected Something2Type something2;
    // getters, setters
}