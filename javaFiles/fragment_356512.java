@Bean
public TokenStore tokenStore() {
    MyJwtTokenStore jwtTokenStore = new MyJwtTokenStore(accessTokenConverter());
    return jwtTokenStore;
    // return new JwtTokenStore(accessTokenConverter());
}