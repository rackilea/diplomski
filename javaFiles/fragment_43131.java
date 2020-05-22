http.authorizeRequests()
    .antMatchers("/login").isAnonymous() // anonymous user access this page
    .antMatchers("/", "/home").isAuthenticated() // now home will be check authentication first
    .antMatchers("/admin/**").access("hasRole('ADMIN')")
    .and().formLogin().loginPage("/login")
    .usernameParameter("ssoId").passwordParameter("password")
    .and().csrf()
    .and().exceptionHandling().accessDeniedPage("/Access_Denied");