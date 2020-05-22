@Bean
@Primary
public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(this.tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    defaultTokenServices.setTokenEnhancer(this.accessTokenConverter());
    defaultTokenServices.setAccessTokenValiditySeconds(100);
    return defaultTokenServices;
}