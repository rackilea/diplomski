@Override
public Window deserialize(JsonParser jsonParser, DeserializationContext dc) throws IOException, JsonProcessingException {
    JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    String value1 = jsonNode.hasNonNull("value1") ? jsonNode.get("value1").asText() : null;
    String value2 = jsonNode.hasNonNull("value2") ? jsonNode.get("value2").asText() : null;
    return new Window(value1, value2);
}