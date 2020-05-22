@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {


  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_XML);
  }
}