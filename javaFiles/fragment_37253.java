@Override
public void configure(final HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests().anyRequest().authenticated();
}

@Primary
@Bean
public UserInfoTokenServices tokenService() {
    final UserInfoTokenServices tokenService = new UserInfoTokenServices(USER_INFO_ENDPOINT, "");
    return tokenService;
}