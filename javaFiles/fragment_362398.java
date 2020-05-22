@XmlAccessorType(XmlAccessType.FIELD)
public class Info {

    @XmlAttribute
    private String key;

    @XmlValue
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}