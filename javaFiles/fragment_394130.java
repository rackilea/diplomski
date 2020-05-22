@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

   public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ForceHerokuSslInterceptor());
   }
}