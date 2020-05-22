public void addFilters(Environment env, Injector injector) {
    Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(WebFilter.class);
    for (Class<?> annotated : annotatedClasses) {
        env.addFilter(injector.getInstance(annotated), annotated.getAnnotation(WebFilter.class).urlPatterns()[0];
    }
}