@Configuration
@EnableWebSecurity
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF is handled by Vaadin: https://vaadin.com/framework/security
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
                .and().logout().logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                // allow Vaadin URLs and the login URL without authentication
                .regexMatchers("/frontend/.*", "/VAADIN/.*", "/login.*", "/accessDenied").permitAll()
                .regexMatchers(HttpMethod.POST, "/\\?v-r=.*").permitAll()
                // deny any other URL until authenticated
                .antMatchers("/**").fullyAuthenticated()
            /*
             Note that anonymous authentication is enabled by default, therefore;
             SecurityContextHolder.getContext().getAuthentication().isAuthenticated() always will return true.
             Look at LoginView.beforeEnter method.
             more info: https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/anonymous.html
             */
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password("$2a$10$obstjyWMAVfsNoKisfyCjO/DNfO9OoMOKNt5a6GRlVS7XNUzYuUbO").roles("ADMIN");// user and pass: admin 
    }

    /**
    * Expose the AuthenticationManager (to be used in LoginView)
    * @return
    * @throws Exception
    */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}