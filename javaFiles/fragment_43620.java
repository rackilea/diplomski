@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "change_requestType", propOrder = {
    "active",
    "approval",
    "assignedTo",
    "altPoc",
    "poc"
})
public class ChangeRequestType {

    @XmlElement(required = true)
    protected String active;
    @XmlElement(required = true)
    protected String approval;
    @XmlElement(name = "assigned_to", required = true)
    protected AssignedToType assignedTo;
    @XmlElement(name = "alt_poc", required = true)
    protected AltPocType altPoc;
    @XmlElement(required = true)
    protected PocType poc;

  // Getters and setters follow
}