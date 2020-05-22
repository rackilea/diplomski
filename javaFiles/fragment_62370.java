@Configuration
public class SecurityConfig {

@Configuration
@EnableResourceServer
protected static class ResourceServer extends ResourceServerConfigurerAdapter {

    // Identifies this resource server. Usefull if the AuthorisationServer authorises multiple Resource servers
    private static final String RESOURCE_ID = "*****";

    @Resource(name = "OAuth")
    @Autowired
    DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http    
                .authorizeRequests().anyRequest().authenticated();
        // @formatter:on
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
        resources.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
}

@Configuration
@EnableAuthorizationServer
protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Resource(name = "OAuth")
    @Autowired
    DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }
}
}