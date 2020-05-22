@Configuration
@EnableWebMvc
@ComponentScan(basePackages="webapp.base.package")
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");;
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/private/**");;
    }

}