@Bean
public JWTAuthenticationFilter getJWTAuthenticationFilter() {
    final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
    filter.setFilterProcessesUrl("/api/auth/login");
    return filter;
}