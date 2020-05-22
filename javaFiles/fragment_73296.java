@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailService;
    @Autowired private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/js/**","/css/**","/img/**","/webjars/**","/pages/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
        auth
          .jdbcAuthentication()
              .dataSource(dataSource)
              .usersByUsernameQuery(getUserQuery())
              .authoritiesByUsernameQuery(getAuthoritiesQuery())
              .passwordEncoder(shaPasswordEncoder);
    }

    @Bean 
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
         return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .anyRequest().hasAuthority("BASIC_PERMISSION")
            .and()
        .formLogin()
            .loginPage("/login/login")
            .defaultSuccessUrl("/login/success-login", true)
            .failureUrl("/login/error-login")
            .loginProcessingUrl("/login/process-login")
            .usernameParameter("security_username")
            .passwordParameter("security_password")
            .permitAll() 
            .and()
        .logout()
            .logoutSuccessUrl("/login/login")
            .logoutUrl("/login/logout")
            .permitAll()
            .and()
        .rememberMe()
            .key("your_key")
            .rememberMeServices(rememberMeServices())
            .and()
        .csrf()
            .disable();
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        // Key must be equal to rememberMe().key() 
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("your_key", userDetailService);
        rememberMeServices.setCookieName("remember_me_cookie");
        rememberMeServices.setParameter("remember_me_checkbox");
        rememberMeServices.setTokenValiditySeconds(2678400); // 1month
        return rememberMeServices;
    }

    @Bean
    public UserDetailsService userDetailService() {
        return new SecurityUserDetailService();
    }

    private String getUserQuery() {
        return "SELECT username as username, password as password, active as enabled "
                + "FROM employee "
                + "WHERE username = ?";
    }

    private String getAuthoritiesQuery() {
        return "SELECT DISTINCT employee.username as username, permission.name as authority "
                + "FROM employee, employee_role, role, role_permission, permission "
                + "WHERE employee.id = employee_role.employee_id "
                + "AND role.id = employee_role.role_id "
                + "AND role.id = role_permission.role_id "
                + "AND permission.id = role_permission.permission_id "
                + "AND employee.username = ? "
                + "AND employee.active = 1";
    }
}