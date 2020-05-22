public class StringValueDeserializer  extends JsonDeserializer<String>{

    @Override
    public String deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectCodec codec = parser.getCodec();
        TreeNode node = codec.readTree(parser);
        JsonNode value = (JsonNode)node.get("value");

        if (value != null){
            return value.asText();
        }
        return null;
    }
}