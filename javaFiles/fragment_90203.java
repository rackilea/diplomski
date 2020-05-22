@XmlRootElement
public class Response {

    private List<Detail> detail;

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
    public List<Detail> getDetail() {
        return detail;
    }

}

public class Detail {

    private String id;
    /* add other attributes here */

    @XmlAttribute(name = "Id")
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

}