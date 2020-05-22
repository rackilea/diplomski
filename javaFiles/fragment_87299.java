String id;

@JsonProperty("ID")
private void unpackNameFromNestedObject(Map<String, String> id) {
    this.id= id.get("uniqueID");
}