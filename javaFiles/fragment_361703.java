@Override
        public void configure(WebSecurity web) throws Exception {
            web
              .ignoring()
                .antMatchers(HttpMethod.yourMethod, "**/heathCheck/**");
        }

@Override
protected void configure(HttpSecurity http) throws Exception {
            http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "**/heathCheck/*").permitAll()
            .anyRequest()
            .access("isFullyAuthenticated() and hasAnyRole('ROLE_ADMIN','ROLE_USER')");
}