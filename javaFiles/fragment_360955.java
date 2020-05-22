public class ADeserializer extends StdDeserializer<A> {
    public ADeserializer() {
        super(A.class);
    }

    @Override
    public A deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.readValueAsTree();
        JsonNode customField = node.findValue("customField");
        A result;
        if (customField != null && !customField.isNull()) {
            result = new C();
            ((C)result).customField = customField.asText();
        } else {
            result = new B();
        }
        result.commonField = node.findValue("commonField").asText();
        return result;
    }
}