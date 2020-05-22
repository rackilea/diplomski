protected void configure(HttpSecurity http) throws Exception {
 http
            .formLogin()
            .and()
            .authorizeRequests()
            .antMatchers("/index").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/index").hasRole("USER")
            .and()
            .csrf().disable();

}