@EnableWebMvc
@Configuration
@ComponentScan
public class RestServiceConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new ProtobufHttpMessageConverter());
    }
}