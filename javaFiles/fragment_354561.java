public static class Product {
    private Integer id;
    private String name;
    private String standardUrl;

    public Product(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("primary_image") JsonNode primaryImage) {
        this.id = id;
        this.name = name;
        this.standardUrl = primaryImage.path("standard_url").asText();
    }
}