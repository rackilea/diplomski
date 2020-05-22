http
    .requestMatchers()
        .antMatchers("/api/user/**", "/api/ticket/**", "/index")
        .and()
    .httpBasic()
        .disable()
    .authorizeRequests()
        .any()
            .hasRole("ROLE_USER");