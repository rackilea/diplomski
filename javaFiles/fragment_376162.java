@EnableWebMvc
@ComponentScan(basePackages = {"com.whatever"})
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserSession userSession() {
        return new UserSession();
    }

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor(); // let Spring go nuts injecting stuff
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()); // will always refer to the same object returned once by myInterceptor()
    }

    ...
}