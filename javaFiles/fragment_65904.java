@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired 
  SecurityInterceptor securityInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(securityInterceptor); 
  }
}