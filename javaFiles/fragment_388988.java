@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(Http.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }
}