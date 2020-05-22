@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("kleber")
                .password("123")
                .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/css/**", "/fonts/**", "/image/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/spring/index").permitAll()
                .loginProcessingUrl("/spring/login").permitAll()
                .usernameParameter("login")
                .passwordParameter("senha")
                .successHandler(new CustomAuthenticationSuccessHandler())
                .failureHandler(new CustomAuthenticationFailureHandler())
                .and()
            .logout()
                .logoutUrl("/spring/logout")
                .logoutSuccessUrl("/spring/index").permitAll();
    }

}