@XStreamAlias("Object")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class ResponseObject {

    @XStreamAlias("Type")
    private String type;

    private String value;

    public ResponseObject() {
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}