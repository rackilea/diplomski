@Configuration
public class SecurityConfig {

@Autowired
private DataSource dataSource;

@Autowired
private ClientDetailsService clientDetailsService;

@Bean
public TokenStore tokenStore() {
    return new InMemoryTokenStore();
}

@Bean
public DefaultTokenServices tokenServices() throws Exception {
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setAccessTokenValiditySeconds(6000);
    tokenServices.setClientDetailsService(clientDetailsService);
    tokenServices.setTokenEnhancer(new MyTokenEnhancer());
    tokenServices.setSupportRefreshToken(true);
    tokenServices.setTokenStore(tokenStore());
    return tokenServices;
}

@Bean
public UserApprovalHandler userApprovalHandler() throws Exception {
    MyUserApprovalHandler handler = new MyUserApprovalHandler();
    handler.setApprovalStore(approvalStore());
    handler.setClientDetailsService(clientDetailsService);
    handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
    handler.setUseApprovalStore(true);
    return handler;
}

@Bean
public ApprovalStore approvalStore() {
    TokenApprovalStore store = new TokenApprovalStore();
    store.setTokenStore(tokenStore());
    return store;
}

@Bean
public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
    return new OAuth2AccessDeniedHandler();
}

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebSecurity
protected static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${baseUrl}") 
    private String baseUrl;

    @Autowired
    private DataSource dataSource;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;

    @Bean
    public ClientDetailsService clientDetailsService() throws Exception {
        ClientDetailsServiceConfiguration serviceConfig = new ClientDetailsServiceConfiguration();

        serviceConfig.clientDetailsServiceConfigurer().inMemory()
            .withClient("***-***-****")
            .secret("???????????????????????????????")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("play", "trust")
        .and()
            .withClient("***-******-**")
            .authorizedGrantTypes("implicit")
            .authorities("ROLE_USER", "ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("play", "trust")
            .redirectUris(baseUrl + "/o2c.html")
            .autoApprove(true)
        .and()
            .withClient("******-***********")
            .secret("???????????????????????????????????")
            .authorizedGrantTypes("password", "authorization_code", "refresh_token")
            .authorities("ROLE_USER", "ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("play", "trust")
            .redirectUris("https://www.runscope.com/oauth_tool/callback")
            .autoApprove(true);

        return serviceConfig.clientDetailsService();
    }

    @Bean
    UserDetailsService clientDetailsUserDetailsService() throws Exception {
        return new ClientDetailsUserDetailsService(clientDetailsService());
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> jdbcUserDetail = new JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder>();
        jdbcUserDetail.dataSource(dataSource);
        jdbcUserDetail.passwordEncoder(passwordEncoder);
        jdbcUserDetail.authoritiesByUsernameQuery("select a.username, r.role_name from account a, role r, account_role ar where a.id = ar.account_id and r.id = ar.role_id and a.username = ?");
        jdbcUserDetail.usersByUsernameQuery("select a.username, a.password, a.enabled, a.email from account a where a.username = ?");
        auth.apply(jdbcUserDetail);

        auth.userDetailsService(clientDetailsUserDetailsService());


    }

    @Bean(name="authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected AuthenticationEntryPoint authenticationEntryPoint() {
        OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
        entryPoint.setTypeName("Basic");
        entryPoint.setRealmName("app/client");
        return entryPoint;
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity
            .ignoring()
            .antMatchers("/resources/**", "/swagger/**", "/copyright*", "/api-docs/**")
        .and()
            .debug(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.anonymous().disable()
            .antMatcher("/oauth/token")
            .authorizeRequests().anyRequest().authenticated()
        .and()
            .httpBasic().authenticationEntryPoint(authenticationEntryPoint())
        .and()
            .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/token")).disable()
            .exceptionHandling().accessDeniedHandler(oAuth2AccessDeniedHandler)
        .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // @formatter:on

        ClientCredentialsTokenEndpointFilter filter = new ClientCredentialsTokenEndpointFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.afterPropertiesSet();
        http.addFilterBefore(filter, BasicAuthenticationFilter.class);
    }

}

@Configuration
@EnableResourceServer
protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Autowired
    private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //resources.tokenServices(tokenServices);
        resources.resourceId("app");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // @formatter:off
        http
            .anonymous()
            .disable();

        // API calls
        http
            .authorizeRequests()
            .regexMatchers(HttpMethod.POST, "/api/.*/accounts")
            .access("#oauth2.hasScope('trust') and #oauth2.hasScope('play') and (hasRole('ROLE_USER'))")
        .and()
            //.addFilterBefore(clientCredentialsTokenEndpointFilter(), BasicAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
        .and()
            .exceptionHandling()
            .accessDeniedHandler(oAuth2AccessDeniedHandler);

        // API calls
        http
            .authorizeRequests()
            .antMatchers("/api/**")
            .access("#oauth2.hasScope('trust') and #oauth2.hasScope('play') and (hasRole('ROLE_USER'))")
        .and()
            //.addFilterBefore(clientCredentialsTokenEndpointFilter(), BasicAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
        .and()
            .exceptionHandling()
            .accessDeniedHandler(oAuth2AccessDeniedHandler);
        // @formatter:on
    }

}

@Configuration
@EnableAuthorizationServer
protected static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DefaultTokenServices tokenServices;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .tokenServices(tokenServices)
        .userApprovalHandler(userApprovalHandler)
        .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
            throws Exception {
        oauthServer.authenticationEntryPoint(authenticationEntryPoint)
                .realm("app/clients");
    }

}

}