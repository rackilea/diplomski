@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .logout()
            .logoutSuccessUrl("http://your-auth-server/exit");
}