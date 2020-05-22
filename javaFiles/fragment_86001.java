@Override
    protected void configure(HttpSecurity http) throws Exception {
        log.warn("Configure http");
        http.csrf().disable()
            .authorizeRequests()
//          .antMatchers("/**")
            .anyRequest()
            .authenticated()
            .and().httpBasic();
    }