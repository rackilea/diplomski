@Override
protected void addInterceptors(final InterceptorRegistry registry) {
    registry.addInterceptor(new ThymeleafLayoutInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/json/**", "/static/**");
}