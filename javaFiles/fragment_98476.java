public class MyJsonSerializer extends JsonSerializer<JsonObject> {

        @Override
        public void serialize(JsonObject value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException, JsonProcessingException {

            gen.writeRaw(value.toJson());
        }
    }


    @Provider
    public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

        private static final ObjectMapper MAPPER = new ObjectMapper();

        static {
            MAPPER.setSerializationInclusion(Include.NON_NULL);
            MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }

        public JacksonJsonProvider() {

            SimpleModule simpleModule = new SimpleModule("SimpleModule", new Version(1,0,0,null, null, null));
            simpleModule.addSerializer(JsonObject.class, new MyJsonSerializer());
            MAPPER.registerModule(simpleModule);

        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            LOGGER.debug("JacksonProvider.getContext() called with type: "+type);
            return MAPPER;
        }
    }