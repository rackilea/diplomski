protected void configure(HttpSecurity http) throws Exception {
    http.requestMatchers().antMatchers("/**").and().csrf().disable().authorizeRequests()
            .antMatchers("/oauth2/login","/logout").permitAll()
            .antMatchers("/oauth/authorize").authenticated()
            .and().formLogin().loginPage("/oauth2/login").loginProcessingUrl("/login").permitAll();
}