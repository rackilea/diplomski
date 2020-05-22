@Order(Ordered.HIGHEST_PRECEDENCE) // This should "overrule" Activiti's security
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/abc/**")
            .authorizeRequests().anyRequest().permitAll();
    }
}