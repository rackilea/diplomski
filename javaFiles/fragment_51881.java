@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
                .antMatchers("/resources/**", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll().successHandler(authenticationSuccessHandler) // See here
                .and()
            .logout()
                .permitAll();
}