@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();

    http.authorizeRequests()
        .antMatchers("/register", "/javax.faces.resource/**").permitAll()
        .antMatchers("/**").authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .usernameParameter("username").passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
}