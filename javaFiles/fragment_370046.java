@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(
      List<HttpMessageConverter<?>> converters) {    
        messageConverters.add(new DirectionConverter()); 
        super.configureMessageConverters(converters);
    }
}