String brandName;

@JsonProperty("brand")
private void unpackNameFromNestedObject(Map<String, String> brand) {
    brandName = brand.get("name");
}