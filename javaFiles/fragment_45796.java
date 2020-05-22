public static class Example {
    private String value;
    private String type;

    @JsonIgnore
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    @JsonRawValue
    public Object getRawValue() {
        if("String" .equals(type)){
            return '"'+ value +'"';
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}