@Configuration
@EnableAuthorizationServer
@SuppressWarnings("static-method")
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws Exception {
        JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
        jwt.setSigningKey(SecurityConfig.key("rsa"));
        jwt.setVerifierKey(SecurityConfig.key("rsa.pub"));
        jwt.afterPropertiesSet();
        return jwt;
    }

    @Autowired
    private AuthenticationManager   authenticationManager;

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .authenticationManager(authenticationManager)
        .accessTokenConverter(accessTokenConverter());
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withClient("myclientwith")
        .authorizedGrantTypes("password")
        .authorities("myauthorities")
        .resourceIds("myresource")
        .scopes("myscope")

        .and()
        .withClient("myclientwithout")
        .authorizedGrantTypes("password")
        .authorities("myauthorities")
        .resourceIds("myresource")
        .scopes(UUID.randomUUID().toString());
    }
}