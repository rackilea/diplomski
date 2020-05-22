public class MyObjectDeserializer extends JsonDeserializer<MyObject> {

    @Override
    public MyObject deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = p.getCodec();
        JsonNode json = coded.readTree(p);
        JsonNode translatedJson = translate(json);

        // continue processing MyObject like ObjectMapper#readValue would using the translated json
        return codec.treeToValue(node, MyObject.class);
    }

    private JsonNode translate(final JsonNode json) {
        ObjectNode object = (ObjectNode) json;

        // Update 'first' to 'new'
        object.put("new", object.get("first").asText()).remove("first");

        // Find the max in 'seconds' and add it as 'second'
        JsonNode seconds = object.get("seconds");
        int max = 0;
        for (int i = 0; i < seconds.size(); i++) {
            max = Math.max(max, seconds.get(i).asInt());
        }
        object.put("second", max).remove("seconds");

        return object;
    }
}