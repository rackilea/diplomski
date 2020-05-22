class InitializeUserDetailsManagerConfigurer
        extends GlobalAuthenticationConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (auth.isConfigured()) {
            return;
        }
}