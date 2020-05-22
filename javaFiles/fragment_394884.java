@Override
public Window deserialize(JsonParser jsonParser, DeserializationContext dc) throws IOException, JsonProcessingException {
    JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
    String field = jsonParser.nextFieldName();
    String nextField = jsonParser.nextFieldName();
    return new Window(field + nextField, jsonNode.getNodeType().toString());
}