@Bean
public RestTemplate restTemplate() {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jackson2HalModule());

    final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
    converter.setObjectMapper(mapper);

    return new RestTemplate(Collections.<HttpMessageConverter<?>> singletonList(converter));
}