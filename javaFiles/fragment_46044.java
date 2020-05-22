@JsonCreator
public ImportResultItemImpl(@JsonProperty("name") String name, 
        @JsonProperty("resultType") ImportResultItemType resultType, 
        @JsonProperty("message") String message) {
    super();
    this.resultType = resultType;
    this.message = message;
    this.name = name;
}