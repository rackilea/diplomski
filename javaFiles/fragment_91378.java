@Bean
public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    builder.propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    builder.serializationInclusion(Include.NON_NULL);
    return builder;
}