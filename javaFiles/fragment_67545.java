@Bean
protected TokenStore tokenStore() {
    return new InMemoryTokenStore();
}

@Bean
protected JwtAccessTokenConverter jwtTokenEnhancer() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey(privateKey);
    converter.setVerifierKey(publicKey);
    return converter;
}

@Override
public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory().withClient("client_trusted")//...
    ;
}

@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore())
        .tokenEnhancer(jwtTokenEnhancer()) // <- tokens are encoded in JWT
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
    }