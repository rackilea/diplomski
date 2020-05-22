@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Profile {

    @XmlElement
    private String name;

    @XmlElement(name = "attribute")
    private List<Attribute> attributes;
}