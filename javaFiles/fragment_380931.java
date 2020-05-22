public class JsonTextSerializer implements MessageSerializer.NegotiatedSerializer<String, ByteString> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public MessageProtocol protocol() {
        return new MessageProtocol(Optional.of("application/json"), Optional.empty(), Optional.empty());
    }

    @Override
    public ByteString serialize(String s) throws SerializationException {
        try {
            return ByteString.fromArray(mapper.writeValueAsBytes(s));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}