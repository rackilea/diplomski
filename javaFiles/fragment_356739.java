@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = package_location)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService detailsService;

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
        //the password encoder here is only to support a mix of encoding - that change can be removed
        auth.userDetailsService(detailsService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/awsorchestrator/**")
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .csrf()
                .disable();
    }
}