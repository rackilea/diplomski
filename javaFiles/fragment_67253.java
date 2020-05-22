http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/api/**")  // all url with /api/** will be authenticated having role of USER.
                .hasRole("USER")
                .anyRequest()
                .fullyAuthenticated();