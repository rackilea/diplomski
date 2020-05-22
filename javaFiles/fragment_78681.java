class MetaDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        JsonNode tree = jp.readValueAsTree();
        return tree.get("links").get("next").asText();
    }
}