@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    @XmlAttribute(name="attribute1")
    String attribute1;

    @XmlAttribute(name="attribute2")
    String attribute2;

    @XmlAttribute(name="attribute3")
    String attribute3;

    @XmlAnyAttribute
    Map<String, String> attributes;
}