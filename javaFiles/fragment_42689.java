public static class CustomDeserializer extends JsonDeserializer<Group> {

    @Override
    public Group deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Group group = new Group();
        ObjectNode objectNode = new ObjectMapper().readTree(jp);
        // assume only a single field...
        Entry<String, JsonNode> field = objectNode.fields().next();
        group.id = field.getKey();

        // there might be a nicer way to do this...
        group.values = new ArrayList<Integer>();
        for (JsonNode node : ((ArrayNode)field.getValue())) {
            group.values.add(node.asInt());
        }
        return group;
    }
}