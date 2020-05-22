@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Bean
 public PasswordEncoder getPasswordEncoder(@Value(value="${password.secret}") String secret) { 
  return new StandardPasswordEncoder(secret);
 }
}