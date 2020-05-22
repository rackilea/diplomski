@JsonProperty("value")
public String setValue(String value) {
    if ("bar".equals(value)) {
        throw new RuntimeException("value " + value + " is inappropriate.");
    }
    this.value = value;
}