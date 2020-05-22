@XmlRootElement(name="Date")
public class TestPojo {

    @XmlMixed
    @XmlAnyElement
    private List<Object> textContent;

    @XmlElement
    private Reference reference;

}