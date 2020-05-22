@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    CacheControl cacheControl = CacheControl.empty().cachePrivate();
    registry.addResourceHandler("/**")
                .setCacheControl(cacheControl);
}