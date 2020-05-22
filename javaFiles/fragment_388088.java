@EnableWebSecurity
@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/register", "/console/**").permitAll();
                .anyRequest().authenticated()
                .and()
            .headers()
                .frameOptions().disable()
                .and()
            .csrf().disable();
    }
}