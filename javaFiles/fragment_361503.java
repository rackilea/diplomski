@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //Enables @PreAuthorize on methods
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private LDAPConfigurationBean ldapBean;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //LDAP Stuff

        TicketAndLDAPAuthenticationProvider ticketAndLDAPAuthenticationProvider = new TicketAndLDAPAuthenticationProvider(authenticator,authoritiesPopulator);
        auth.authenticationProvider(ticketAndLDAPAuthenticationProvider);

        LdapAuthenticationProvider ldapAuthenticationProvider = new LdapAuthenticationProvider(authenticator,authoritiesPopulator);
        auth.authenticationProvider(ldapAuthenticationProvider);    
    }

    //Management Endpoints Authorization
    @Configuration
    @Order(1)
    public static class EndpointsWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/manage/health")
                    .authorizeRequests()
                    .anyRequest().permitAll();
        }
    }

    //API Authentication+Authorization
    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private RestAuthenticationEntryPoint authenticationEntryPoint;
        @Autowired
        private RestAuthSuccessHandler authSuccessHandler;
        @Autowired
        private RestAuthFailureHandler authFailureHandler;
        @Autowired
        private RestLogoutSuccessHandler logoutSuccessHandler;

        private String LOGIN_PATH = "/api/authenticate";

        protected void configure(HttpSecurity http) throws Exception {
            /*CSRF configuration*/
            http.csrf().disable();

            http.addFilterBefore(new TicketAndLDAPAuthenticationFilter(LOGIN_PATH,authSuccessHandler,authFailureHandler), UsernamePasswordAuthenticationFilter.class);

            http
                    .antMatcher("/api/**")
//                    Stateless session creation - no session will be created or used by Spring Security
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .exceptionHandling()
                        .authenticationEntryPoint(authenticationEntryPoint)
                    .and()
                    .logout().permitAll()
                        .logoutSuccessHandler(logoutSuccessHandler);

            http
                    .authorizeRequests().anyRequest().authenticated();

        }
    }

    //JSP Authentication+Authorization
    @Configuration
    @Order(3)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        private String LOGIN_PATH = "/login.htm";

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            /*CSRF configuration*/
            http.csrf().disable();

            http.addFilterBefore(new TicketAndLDAPAuthenticationFilter(LOGIN_PATH), UsernamePasswordAuthenticationFilter.class);

            /*Static content*/
            http
                    .authorizeRequests()
                    .antMatchers("/css*//**").permitAll()
                    .antMatchers("/images*//**").permitAll()
                    .antMatchers("/scripts*//**").permitAll()
                    .antMatchers("/fonts*//**").permitAll()
                    .antMatchers("/login*").anonymous();

        /*Login / Logout configuration*/
            http
                    .formLogin()
                        .loginPage(LOGIN_PATH).permitAll()
                        .defaultSuccessUrl("/index.htm?name=******")
                        .failureUrl("/login.htm?error=true")
                    .and()
                    .logout().permitAll()
                        .logoutSuccessUrl("/login.htm")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID");

        /*URL roles authorizations*/
            http
                    .authorizeRequests().anyRequest().authenticated();
        }
    }
}