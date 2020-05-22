@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private AuthenticationEntryPoint authenticationEntryPoint;

@Autowired
private AccessDeniedHandler accessDeniedHandler;

@Autowired
private GenericFilterBean filter;


@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/webjars/**", "/images/**", "/oauth/uncache_approvals", "/oauth/cache_approvals");
}

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userAuthenticationManager()).passwordEncoder(passwordEncoder());
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
      .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler) // handle access denied in general (for example comming from @PreAuthorization
        .authenticationEntryPoint(authenticationEntryPoint) // handle authentication exceptions for unauthorized calls.
    .and()
      .authorizeRequests()
        .antMatchers("/xxx/**").fullyAuthenticated()
        .antMatchers("/xxx/**").fullyAuthenticated()
        .antMatchers("/xxx/**").fullyAuthenticated()
     .and()
       .csrf().disable();;
}

@Bean
@Autowired
ApplicationListener<AbstractAuthenticationEvent> loggerBean() {
    return new org.springframework.security.authentication.event.LoggerListener();
}

@Bean
@Autowired
AccessDeniedHandler accessDeniedHandler() {
    return new AccessDeniedExceptionHandler();
}

@Bean
@Autowired
AuthenticationEntryPoint entryPointBean() {
    return new UnauthorizedEntryPoint();
}

@Bean
public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

@Bean(name="userAuthenticationManager")
public UserDetailsService userAuthenticationManager() throws Exception {
    return new UserServiceImpl();
}

@Bean
public UserService userService() {
    return new UserServiceImpl();
}   
}