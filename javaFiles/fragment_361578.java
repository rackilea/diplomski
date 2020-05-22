@Bean
public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
    DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping = new DefaultAnnotationHandlerMapping();
    defaultAnnotationHandlerMapping.setOrder(-1);
    // and other properties
    return defaultAnnotationHandlerMapping;
}