@SuppressWarnings("deprecation")
protected final void addDefaultHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
    StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
    stringConverter.setWriteAcceptCharset(false);

    messageConverters.add(new ByteArrayHttpMessageConverter());
    messageConverters.add(stringConverter);
    messageConverters.add(new ResourceHttpMessageConverter());
    messageConverters.add(new SourceHttpMessageConverter<Source>());
    messageConverters.add(new AllEncompassingFormHttpMessageConverter());
    if (romePresent) {
        messageConverters.add(new AtomFeedHttpMessageConverter());
        messageConverters.add(new RssChannelHttpMessageConverter());
    }
    if (jaxb2Present) {
        messageConverters.add(new Jaxb2RootElementHttpMessageConverter());
    }
    if (jackson2Present) {
        messageConverters.add(new MappingJackson2HttpMessageConverter());
    }
    else if (jacksonPresent) {
        messageConverters.add(new org.springframework.http.converter.json.MappingJacksonHttpMessageConverter());
    }
}