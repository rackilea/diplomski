public class WebConfig extends WebMvcAutoConfigurationAdapter {
    ...
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(customArgumentResolver);
    }
    ...
}