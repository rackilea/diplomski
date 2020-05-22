public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> conf 
            = auth.inMemoryAuthentication();
    conf.withUser("admin").password("secret").roles("ADMIN");
    conf.withUser("user").password("secret").roles("USER");
}