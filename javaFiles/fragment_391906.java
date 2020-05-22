@Configuration
@EnableWebMvc
@Import({RootTestConfig.class, WebCommonSecurityConfig.class})
public class WebTestConfig  extends WebMvcConfigurerAdapter{


  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new ServletWebArgumentResolverAdapter(new DeviceWebArgumentResolver()));
    argumentResolvers.add(new SitePreferenceHandlerMethodArgumentResolver());
  }
}