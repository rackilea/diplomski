@Bean
public StringHttpMessageConverter stringMessageConverter() {
    return new StringHttpMessageConverter();
}


@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(jacksonConverter());
    converters.add(stringMessageConverter());
}