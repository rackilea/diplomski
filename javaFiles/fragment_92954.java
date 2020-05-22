@Bean
public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
    b.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    return b;
}