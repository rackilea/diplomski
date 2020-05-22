@Configuration
@EnableWebMvc
public class MyWebConfig extends WebMvcConfigurerAdapter 
{
  @Override
  public void addInterceptors(InterceptorRegistry registry) 
  {
    registry.addInterceptor(new MyCustomInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/images/**");
  }
}