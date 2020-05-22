public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/js/**")
        .addResourceLocations("/js/")
        .setCachePeriod(3600)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
}