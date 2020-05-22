private List<HttpMessageConverter<?>> potentiallyRegisterModule(List<HttpMessageConverter<?>> converters) {

    for (HttpMessageConverter<?> converter : converters) {
        if (converter instanceof MappingJackson2HttpMessageConverter) {
            MappingJackson2HttpMessageConverter halConverterCandidate = (MappingJackson2HttpMessageConverter) converter;
            ObjectMapper objectMapper = halConverterCandidate.getObjectMapper();
            if (Jackson2HalModule.isAlreadyRegisteredIn(objectMapper)) {
                return converters;
            }
        }
    }

    CurieProvider curieProvider = getCurieProvider(beanFactory);
    RelProvider relProvider = beanFactory.getBean(DELEGATING_REL_PROVIDER_BEAN_NAME, RelProvider.class);
    ObjectMapper halObjectMapper = beanFactory.getBean(HAL_OBJECT_MAPPER_BEAN_NAME, ObjectMapper.class);

    halObjectMapper.registerModule(new Jackson2HalModule());
    halObjectMapper.setHandlerInstantiator(new Jackson2HalModule.HalHandlerInstantiator(relProvider, curieProvider));

    MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
    halConverter.setSupportedMediaTypes(Arrays.asList(HAL_JSON)); //HAL_JSON is just a MediaType instance for application/hal+json
    halConverter.setObjectMapper(halObjectMapper);

    List<HttpMessageConverter<?>> result = new ArrayList<HttpMessageConverter<?>>(converters.size());
    result.add(halConverter);
    result.addAll(converters);
    return result;
}