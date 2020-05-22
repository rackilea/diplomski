public class PathJsonDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser parser, DeserializationContext context) 
                  throws IOException, JsonProcessingException {

        JsonToken token = parser.getCurrentToken();
        if (token.equals(JsonToken.START_OBJECT)) {
            // This String value looks like an object - try to parse $relative
            Path path = parser.readValueAs(Path.class);
            return path.$relative;
        } else {
            // This is normal String value
            return parser.getText();
        }
    }
}