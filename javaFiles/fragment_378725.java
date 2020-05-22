@XmlRootElement(name="master")
public class DummyMaster {

    private String name;
    private List<DummyDetail> details;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @XmlElement(name = "detail")
    public List<DummyDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DummyDetail> details) {
        this.details = details;
    }
}