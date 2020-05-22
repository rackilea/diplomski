@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
@Value("${security.jwt.client-id}")
private String clientId;

@Value("${security.jwt.client-secret}")
private String clientSecret;

@Value("${security.jwt.grant-type}")
private String grantType;

@Value("${security.jwt.grant-type-other}")
private String grantTypeRefresh;

@Value("${security.jwt.scope-read}")
private String scopeRead;

@Value("${security.jwt.scope-write}")
private String scopeWrite = "write";

@Value("${security.jwt.resource-ids}")
private String resourceIds;

@Autowired
private TokenStore tokenStore;

@Autowired
private JwtAccessTokenConverter accessTokenConverter;

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private AppUserDetailsService userDetailsService;

@Autowired
private PasswordEncoder passwordEncoder;


@Override
public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
    configurer.inMemory()
            .withClient(clientId)
            .secret(passwordEncoder.encode(clientSecret))
            .authorizedGrantTypes(grantType, grantTypeRefresh).scopes(scopeRead, scopeWrite)
            .resourceIds(resourceIds).autoApprove(false).accessTokenValiditySeconds(1800) // 30min
            .refreshTokenValiditySeconds(86400); //24 hours
}

@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
    endpoints.tokenStore(tokenStore).accessTokenConverter(accessTokenConverter).tokenEnhancer(enhancerChain)
            .reuseRefreshTokens(false).authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService);
}

@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*"); // http://localhost:4200
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
}