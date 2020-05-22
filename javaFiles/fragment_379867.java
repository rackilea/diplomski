@Bean
public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.authorizeExchange()
        .pathMatchers("/users/admin/**")
        .hasRole("ADMIN")
        .pathMatchers("/**").permitAll()
        .and().httpBasic();
    return http.build();
}