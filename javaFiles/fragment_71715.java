public class SerializeDeserializeAttributes {
    private final ObjectMapper mapper = new ObjectMapper();

public <T> T fromJson(String json, Class<T> c) throws IOException {
    synchronized (mapper) {
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, false);
        return mapper.readValue(json, c);
    }
}

public String toJson(Object o) throws JsonProcessingException {
    synchronized (mapper) {
        mapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        return mapper.writeValueAsString(o);
    }
}

    private static final String jsonFull = "{\"name\":\"A\",\"email\":\"a@a\",\"password\":\"a\",\"width\":1,\"height\":1}";
    private static final String jsonPartial = "{\"name\":\"A\",\"email\":\"a@a\",\"width\":1,\"height\":1}";
    private static final User user = new User("A", "a@a", "a", 1, 1);

    @Test
    public void serializeDeserialize() throws IOException {
        assertEquals(user, fromJson(jsonFull, User.class));
        assertEquals(jsonPartial, toJson(user));
        assertEquals(user, fromJson(jsonFull, User.class));
        assertEquals(jsonPartial, toJson(user));
    }
}