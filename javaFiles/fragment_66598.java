@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
            .authenticationManager(authenticationManager)
            .tokenStore(jwtTokenStore())
            .tokenEnhancer(tokenEnhancer());
}