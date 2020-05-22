@Configuration
@ComponentScan
public class RestServiceConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ProtobufHttpMessageConverter());
        super.addDefaultHttpMessageConverters(converters);
    }
}