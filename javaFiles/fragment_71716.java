public class SerializeDeserializeAttributesMixin {

    public abstract class UserMixin {
        @JsonSerialize(using = PwdSerializer.class)
        transient String password;
    }

    static class PwdSerializer extends StdSerializer<String> {

        public PwdSerializer() {
            this(String.class);
        }

        private PwdSerializer(Class<String> t) {
            super(t);
        }

        @Override
        public void serialize(String s, JsonGenerator jg, SerializerProvider sp) throws IOException {
            jg.writeString("");
        }
    }

    private static final String jsonFull = "{\"name\":\"A\",\"email\":\"a@a\",\"password\":\"a\",\"width\":1,\"height\":1}";
    private static final String jsonPartialMixin = "{\"name\":\"A\",\"email\":\"a@a\",\"password\":\"\",\"width\":1,\"height\":1}";
    private static final User user = new User("A", "a@a", "a", 1, 1);
    private static final ObjectMapper mapperMixin = new ObjectMapper();

    static {
        mapperMixin.addMixIn(User.class, UserMixin.class);
    }


    @Test
    public void serializeDeserializeUsingMixin() throws IOException {
        assertEquals(user, mapperMixin.readValue(jsonFull, User.class));
        assertEquals(jsonPartialMixin, mapperMixin.writeValueAsString(user));
    }

}