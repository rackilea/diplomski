@Override
public Window deserialize(JsonParser jsonParser, DeserializationContext dc) throws IOException, JsonProcessingException {
    // Assert that the current token is a START_OBJECT token
    if (jsonParser.currentToken() != JsonToken.START_OBJECT) {
        throw dc.wrongTokenException(jsonParser, Window.class, JsonToken.START_OBJECT, "Expected start of Window");
    }

    // Read the next two attributes with value and put them in a map
    // Putting the attributes in a map means we ignore the order of the attributes
    final Map<String, String> attributes = new HashMap<>();
    attributes.put(jsonParser.nextFieldName(), jsonParser.nextTextValue());
    attributes.put(jsonParser.nextFieldName(), jsonParser.nextTextValue());

    // Assert that the next token is an END_OBJECT token
    if (jsonParser.nextToken() != JsonToken.END_OBJECT) {
        throw dc.wrongTokenException(jsonParser, Window.class, JsonToken.END_OBJECT, "Expected end of Window");
    }

    // Create a new window and return it
    return new Window(attributes.get("value1"), attributes.get("value2"));
}