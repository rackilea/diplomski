@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Auto", propOrder = {
        "id", "VIN", "Make", "Model", "Year", "Description", "Cost"
})
public class Auto {
    @XmlElement(name = "id")
    Integer id;
    @XmlElement(name = "VIN")
    String VIN;
    @XmlElement(name = "Make")
    String Make;
    @XmlElement(name = "Model")
    String Model;
    @XmlElement(name = "Year")
    Integer Year;
    @XmlElement(name = "Description")
    String Description;
    @XmlElement(name = "Cost")
    Float Cost;

    // === DON'T FORGET YOUR GETTERS and SETTERS
}