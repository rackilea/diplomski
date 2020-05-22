@Configuration  
public class WebMvcConfig extends WebMvcConfigurerAdapter  {  

  @Autowired
  private RequestInterceptor requestInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestInterceptor)
            .addPathPatterns("/usermanagement/v1/**");
  }
}