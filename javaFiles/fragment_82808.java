public class UserDeserializer extends DelegatingDeserializer {

    public UserDeserializer(JsonDeserializer<?> delegate) {
        super(delegate);
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> newDelegate) {
        return new UserDeserializer(newDelegate);
    }

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        String key = p.getCurrentName();
        User result = (User) super.deserialize(p, ctxt);

        result.userId = key;
        return result;
    }
}