public abstract class UserDefinedResponse {

    @JsonIgnore
    public String customString1;

    @JsonIgnore
    public String customString2;

    @JsonIgnore
    public String customString3;

    @JsonIgnore
    public String customString4;

    @JsonIgnore // Remove if clientId must be serialized
    public String clientId;

    private Map<String, Object> dynamicProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getDynamicProperties() {
        Mapper.fillDynamicProperties(this, this.dynamicProperties);
        return this.dynamicProperties;
    }

    @JsonAnySetter
    public void setDynamicProperty(String name, Object value) {
        this.dynamicProperties.put(name, value);
        Mapper.setDynamicProperty(this.dynamicProperties, name, this);
    }
}