@Override
protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http
            .csrf().disable() // <- THIS LINE
            .authorizeRequests()
            .antMatchers("/**")
            .hasRole("user")
            .anyRequest()
            .authenticated();
}