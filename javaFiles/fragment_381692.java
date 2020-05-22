class CustomDeserializer extends JsonDeserializer<Prices> {

    public CustomDeserializer() { super(); }

    @Override
    public Prices deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.readValueAsTree();

        Iterator<Entry<String, JsonNode>> nodes = node.get("prices").fields();

        while (nodes.hasNext()) {
            Map.Entry<String, JsonNode> entry = nodes.next();

            System.out.println(entry.getKey());

            for (JsonNode tempNode : entry.getValue()) {
                for (int i = 0; i < tempNode.size(); i++) {
                    System.out.println(tempNode.get(i).getClass() + "\t" + tempNode.get(i));
                }
            }

            System.out.println();
        }

        return null;
    }
}