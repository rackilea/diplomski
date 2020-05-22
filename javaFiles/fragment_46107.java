public static class ItemDeserializerJson extends JsonDeserializer<Item> {

    @Override
    public Item deserialize(JsonParser jp, DeserializationContext context) throws IOException {

        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) (node.get("id")).numberValue();
        String itemName = node.get("itemName").asText();

        return new Item(id, itemName);
    }
}