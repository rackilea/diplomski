@Configuration
public class MyAppInjector {

  @Bean
  public AuthService authService() {
    return new JwtAuthService(myAppConfig());
  }

  @Bean
  public MyAppConfig myAppConfig() {
    return new MyAppConfig();
  }

}