public class StringHashMapValueDeserializer extends JsonDeserializer<HashMap<String, String>>{

    @Override
    public HashMap<String, String> deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        HashMap<String, String> ret = new HashMap<String, String>();

        ObjectCodec codec = parser.getCodec();
        TreeNode node = codec.readTree(parser);

        if (node.isArray()){
            for (JsonNode n : (ArrayNode)node){
                JsonNode id = n.get("id");
                if (id != null){
                    JsonNode name = n.get("name");
                    ret.put(id.asText(), name.asText());
                }
            }
        }
        return ret;
    }
}