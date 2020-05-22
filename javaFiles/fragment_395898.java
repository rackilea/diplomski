@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
            .defaultContentType(MediaType.TEXT_HTML)
            .parameterName("type")
            .ignoreUnknownPathExtensions(false)
            .ignoreAcceptHeader(false)
            .favorParameter(true)
            .favorPathExtension(false)
            .useJaf(true);
}