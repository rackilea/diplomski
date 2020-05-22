@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            // other security config
            .addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
}