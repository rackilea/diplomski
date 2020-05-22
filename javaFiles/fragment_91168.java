@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .httpBasic()
                .and()
            .authorizeRequests()
            .antMatchers("/user", "/index.html", "/", "/projects/listHome", "/projects/{id}", "/categories", "/login").permitAll().anyRequest()
            .authenticated()
                .and()
            .csrf().csrfTokenRepository(csrfTokenRepository())
                .and()
            .addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
}