@Bean
public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    registerModule(
        new SimpleModule("foo")
            .addDeserializer(Date.class, new DateDeserializer())
            .addSerializer(Date.class, new DateSerializer())
    );
    return mapper;
}