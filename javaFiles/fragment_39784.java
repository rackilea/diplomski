public class UserDeserializer extends StdDeserializer<User> implements ResolvableDeserializer {

    private final JsonDeserializer<?> defaultDeserializer;

    public UserDeserializer(JsonDeserializer<?> defaultDeserializer) {
        super(User.class);
        this.defaultDeserializer = defaultDeserializer;
    }

    @Override
    public User deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String text = jp.getText();
        JsonToken currentToken = jp.getCurrentToken();

        if(!currentToken.equals(JsonToken.VALUE_NUMBER_INT) && !text.startsWith("{")) {
            try{
                return new User(Integer.parseInt(text));
            }
            catch(Exception e) {
                throw new IOException("Unable to process '" + text + "'. Expecting an ID as an integer or a full json representation of the object.");
            }

        }

        return (User) defaultDeserializer.deserialize(jp, dc);
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        ((ResolvableDeserializer) defaultDeserializer).resolve(ctxt);
    }
}