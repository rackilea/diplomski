public enum Type {

    Private("private"),
    Group("group"),
    Supergroup("supergroup"),
    Channel("channel")

    private String jsonValue;

    private Type(final String json) {
        this.jsonValue = json;
    }

    @JsonValue
    public String jsonValue() {
        return this.jsonValue;
    }

}