public static HttpMessageConverter<Object> HALMessageConverter(){
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new Jackson2HalModule());

    //TODO: need to figure out this curie provider stuff...more in production mode
    DefaultCurieProvider curieProvider = new DefaultCurieProvider("a", new UriTemplate("http://localhost:8080/myapp/rels/{rel}"));
    DefaultRelProvider relProvider = new DefaultRelProvider();

    objectMapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(relProvider, curieProvider));

    MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
    halConverter.setObjectMapper(objectMapper);
    halConverter.setSupportedMediaTypes(Arrays.asList(MediaTypes.HAL_JSON));

    return halConverter;
}