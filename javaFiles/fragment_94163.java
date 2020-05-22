@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Hibernate5Module());
    jacksonConverter.setObjectMapper(mapper);
    converters.add(jacksonConverter);
    super.configureMessageConverters(converters);
}