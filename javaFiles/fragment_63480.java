@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("user1").password("user1").roles("USER", "TENANT1")
            .and()
            .withUser("user2").password("user2").roles("USER", "TENANT2");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/**").hasRole("USER")
            .and()
            .httpBasic()
            .and().csrf().disable();
    }
}