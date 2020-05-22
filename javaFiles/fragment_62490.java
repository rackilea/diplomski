@Bean
public AuthorizationServerConfigurer authorizationServerConfigurer() {
    return new AuthorizationServerConfigurerAdapter() {
        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer
                    .authenticationEntryPoint(customEntryPoint())
                    .allowFormAuthenticationForClients();
        }