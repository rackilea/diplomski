@Bean
public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    return new Jackson2ObjectMapperBuilder() {

        @Override
        public void configure(ObjectMapper objectMapper) {
            super.configure(objectMapper);
            objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        }

    };

}