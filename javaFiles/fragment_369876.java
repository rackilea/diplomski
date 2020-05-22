@Bean(name = "commonsMultipartResolver")
public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
}


@Bean
public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();

    factory.setMaxFileSize("10MB");
    factory.setMaxRequestSize("10MB");

    return factory.createMultipartConfig();
}