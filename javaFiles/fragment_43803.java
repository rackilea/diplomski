@XmlRootElement(name="Date")
public class TestPojo {

    List<Object> textContent;
    Reference ref;

    @XmlMixed
    @XmlAnyElement
    public List<Object> getTextContent() {
        return textContent;
    }

    public void setTextContent(List<Object> textContent) {
        this.textContent = textContent;
    }

    @XmlElement(name="reference")
    public Reference getRef() {
        return ref;
    }

    public void setRef(Reference ref) {
        this.ref = ref;
    }

}