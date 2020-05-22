@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests()
             .antMatchers(HttpMethod.POST, "/user") 
               .permitAll().anyRequest().authenticated();

    }
}