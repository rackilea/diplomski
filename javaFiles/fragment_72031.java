@EnableWebMvc
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    .....
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new YourNewInterceptor());
    }
    .....

}