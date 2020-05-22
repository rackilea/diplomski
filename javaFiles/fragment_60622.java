.logoutSuccessHandler(logoutSuccessHandler)
.and()
.apply(new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    @Override public void configure(HttpSecurity builder) throws Exception {
        builder.getSharedObject(DefaultLoginPageGeneratingFilter.class).setLogoutSuccessUrl("/login?logout");
    }
})