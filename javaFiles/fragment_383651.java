@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired 
  HandlerInterceptor customInjectedInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(...)
    ... 
    registry.addInterceptor(customInjectedInterceptor).addPathPatterns("/**");
  }
}