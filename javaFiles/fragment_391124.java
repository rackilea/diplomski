* Configure ContentNegotiationManager
 */
@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(true).defaultContentType(
            MediaType.TEXT_HTML);
}

/*
 * Configure ContentNegotiatingViewResolver
 */
@Bean
public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setContentNegotiationManager(manager);

    // Define all possible view resolvers
    List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
    resolvers.add(jsonViewResolver());

    resolver.setViewResolvers(resolvers);
    return resolver;
}

 /*
 * Configure View resolver to provide JSON output using JACKSON library to
 * convert object in JSON format.
 */
@Bean
public ViewResolver jsonViewResolver() {
    return new JsonViewResolver();
}