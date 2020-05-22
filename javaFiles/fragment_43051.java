@Configuration
public class YourSpringConf{

  @Bean
    public HandlerInterceptor myInterceptor() {
       return new MyInterceptor();
    }
}