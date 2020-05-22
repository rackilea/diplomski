@JsonPropertyOrder({"name"})
public static class Part {
    @JsonProperty("name")
    private String name;

    public Part() {
        this("");
    }

    public Part(String partJSON) {
        // TODO: Unserialize the parameter... it is a serialized Part string... 
        this.name = partJSON;
    }