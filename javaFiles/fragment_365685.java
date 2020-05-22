@Configuration
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer  {
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
           registry.addInterceptor(new MyInterceptor()).addPathPatterns("/register/student");

     }
}