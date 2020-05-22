@XmlRootElement(name = "ip_address")
@XmlAccessorType(XmlAccessType.FIELD)
public class IPAddress implements Serializable {
    private final static long serialVersionUID = 1L;
    @XmlValue
    protected String content;
    @XmlAttribute(name = "type")
    protected String type;

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setType(String content) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}