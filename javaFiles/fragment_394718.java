httpSecurity
        .requiresChannel()
            .requestMatchers(/* some matchers */)
            .requiresSecure()
            .and()
        .portMapper()
            .portMapper(new MyPortMapper());