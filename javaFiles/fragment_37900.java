http
    .authorizeRequests()
        .anyRequest().authenticated()
        .and()
    .oauth2ResourceServer()
        .jwt()
            .jwtAuthenticationConverter(getJwtAuthenticationConverter());