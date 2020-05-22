@Bean
public HttpMessageConverter mappingJackson2HttpMessageConverter(){
    MappingJackson2HttpMessageConverter jacksonConverter =
            new MappingJackson2HttpMessageConverter(new EventServiceObjectMapper());

    return jacksonConverter;
}

@Override
public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.clear();
    converters.add(new Jaxb2RootElementHttpMessageConverter());
    converters.add(mappingJackson2HttpMessageConverter());
}