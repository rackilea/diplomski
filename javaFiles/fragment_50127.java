public class StringArrayValueDeserializer  extends JsonDeserializer<List<String>>{

    @Override
    public List<String> deserialize(JsonParser parser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

        List<String> ret = new ArrayList<>();

        ObjectCodec codec = parser.getCodec();
        TreeNode node = codec.readTree(parser);

        if (node.isArray()){
            for (JsonNode n : (ArrayNode)node){
                JsonNode value = n.get("value");
                if (value != null){
                    ret.add(value.asText());
                }
            }
        }
        return ret;
    }
}