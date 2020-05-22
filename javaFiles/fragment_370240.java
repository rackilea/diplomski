private static final KeyDeserializer MATCHDAY_KEY_DESERIALIZER = new KeyDeserializer() {

    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new Matchday(Integer.valueOf(key));
    }
};

public static final ObjectMapper OBJECT_MAPPER = createObjectMapper();