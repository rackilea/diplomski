class ItemsJsonDeserializer extends JsonDeserializer<List<Item>> {

    @Override
    public List<Item> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        InnerItems innerItems = jp.readValueAs(InnerItems.class);

        return innerItems.elements;
    }

    private static class InnerItems {
        public List<Item> elements;
    }
}