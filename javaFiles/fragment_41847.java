@Override
protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/login.xhtml").permitAll()
        .antMatchers("/pages/**").access("isAuthenticated()")
        .antMatchers("/run**").access("isAuthenticated()")
        .and().formLogin().loginProcessingUrl("/login").loginPage("/login.xhtml")
        .successHandler(successHandler)
        .failureHandler(failureHandler).defaultSuccessUrl("/pages/dashboard.xhtml")
        .usernameParameter("username")
        .passwordParameter("password")
        .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);

    http.csrf().disable();
  }
 }