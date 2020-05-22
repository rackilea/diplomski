public class UserDeserializer extends JsonDeserializer<User> {

  @Override
  public User deserialize(JsonParser parser, DeserializationContext context) throws IOException,
      JsonProcessingException {
    JsonNode node = parser.getCodec().readTree(parser);
    int userId = (Integer) ((IntNode) node.get("userID")).numberValue();
    return new User(userId); // Placeholder User object containing only the user ID, needs to be replaced in business logic
  }

}