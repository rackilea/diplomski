@Bean
public PagePopulationInterceptor pagePopulationInterceptor() {
    return new PagePopulationInterceptor();
}

public @Override void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(pagePopulationInterceptor());
}