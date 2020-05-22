@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().
        antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").
        and().formLogin().  // login configuration
            loginPage("/customLogin.jsp").
            loginProcessingUrl("/appLogin").
            usernameParameter("app_username").
            passwordParameter("app_password").
            defaultSuccessUrl("/secure/home").  
        and().logout().    // logout configuration
            logoutUrl("/appLogout"). 
            logoutSuccessUrl("/customLogin.jsp?logout");
}