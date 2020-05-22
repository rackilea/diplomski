@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .logout().deleteCookies("SESSION").and()
            .authorizeRequests()
                .antMatchers("/actuator/**","/error").permitAll()
                .anyRequest().authenticated().and()         
            .httpBasic().authenticationEntryPoint(customAuthEntryPoint).and()
            .csrf().disable();
    }