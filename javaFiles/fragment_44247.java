@JsonFormat
public enum Lang {

    ENGLISH("en_US"), 
    FRENCH("fr_CA");

    private String val;

    Lang(String val) {
        this.val = val;
    }

    @JsonValue
    public String getValue() {
        return val;
    }

    @JsonCreator
    public static Lang fromValue(String value) {
        // TODO return the Lang with the given value, or throw an IllegalArgumentException
    }
}