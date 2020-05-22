@Bean
public ObjectMapper objectMapper() {
    JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addSerializer(ZonedDateTime.class,
            new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")));
    javaTimeModule.addDeserializer(ZonedDateTime.class,
            new ZonedDateTimeDeserializer());
    ObjectMapper objMapper = Jackson2ObjectMapperBuilder.json().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISODate
            .modules(javaTimeModule).build();
    return objMapper;
}