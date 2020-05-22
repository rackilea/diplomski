class JsonObjectConverter {

    private ObjectMapper mapper = new ObjectMapper();

    public String serialiseToJson(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not serialise: " + value, e);
        }
    }

    public <T> T deserialiseFromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize: " + clazz, e);
        }
    }

    public SomeSpecificClass deserialiseToSomeSpecificClass(String json) {
        return deserialiseFromJson(json, SomeSpecificClass.class);
    }
}