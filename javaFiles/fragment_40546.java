@Bean
public MappingJackson2HttpMessageConverter MappingJackson2HttpMessageConverter (ApplicationContext applicationContext) {
    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(applicationContext).build();
    return new MappingJackson2HttpMessageConverter(objectMapper) {
        @Override
        protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
            String jsonpFunction =
                    (object instanceof MappingJacksonValue ? ((MappingJacksonValue) object).getJsonpFunction() : null);
            if (jsonpFunction != null) {
                generator.writeRaw(jsonpFunction + "(");
            }
        }

    };
}