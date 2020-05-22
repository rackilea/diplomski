@Configuration
class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(0, new CustomHttpMessageConverter());
    }

    ...
 }