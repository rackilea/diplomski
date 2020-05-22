@XmlAccessorType(XmlAccessType.FIELD)
public class NodeValueElement {

    @XmlAttribute(name="value")
    String value;

    public NodeValueElement() {
    }

    public NodeValueElement(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}