@Bean
public ThemedResourceViewResolver internalResourceViewResolver() {
    ThemedResourceViewResolver resolver = new ThemedResourceViewResolver();

    resolver.setSuffix(".jsp");
    return resolver;
}