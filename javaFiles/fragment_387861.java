@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(mAppConfig.dataSource())
                .withClient("virto")
                .secret("secret")
                .authorizedGrantTypes("client_credentials");
    }
}