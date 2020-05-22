@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assigned_toType", propOrder = {
        "value"
    })
    public class AssignedToType {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "display_value")
        protected String displayValue;

        // Getters and setters follow
}