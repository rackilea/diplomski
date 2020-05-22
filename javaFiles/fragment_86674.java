@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login").permitAll()
            .and()
        .logout().permitAll()
        // Add something like this:
        .sessionManagement()
            .maximumSessions(1)
            .sessionRegistry(sessionRegistry);
}