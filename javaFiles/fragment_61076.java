http
    .antMatcher("/api/**")
    .httpBasic()
        .disable()
    .authorizeRequests()
        .antMatchers("/api/user/**", "/api/ticket/**", "/index")
            .hasRole("ROLE_USER");