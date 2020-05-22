@Bean
@Primary
public DefaultTokenServices tokenServices(TokenEnhancerChain tokenEnhancerChain, ClientDetailsService clientDetailsService) {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);
    defaultTokenServices.setClientDetailsService(clientDetailsService);
    addUserDetailsService(defaultTokenServices,userDetailsService);
    return defaultTokenServices;
}

private void addUserDetailsService(DefaultTokenServices tokenServices, UserDetailsService userDetailsService) {
    if (userDetailsService != null) {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>(
                userDetailsService));
        tokenServices
                .setAuthenticationManager(new ProviderManager(Arrays.<AuthenticationProvider> asList(provider)));
    }
}