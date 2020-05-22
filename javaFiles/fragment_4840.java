@Bean
public JwtAccessTokenConverter accessTokenConverter() {
    final JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
    jwtAccessTokenConverter.setSigningKey(SECRET);
    ((DefaultAccessTokenConverter) jwtAccessTokenConverter.getAccessTokenConverter())
            .setUserTokenConverter(userAuthenticationConverter());
    return jwtAccessTokenConverter;
}