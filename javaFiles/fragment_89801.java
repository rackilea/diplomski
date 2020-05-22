protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic()
            .and()
        .authorizeRequests()
            .anyRequest().hasRole("USER");
}