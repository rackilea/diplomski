httpSecurity.requestMatchers()
    .antMatchers("/ui/**", "/login", "/logout")
    .authorizeRequests().anyRequest().authenticated()
    .and()
    .formLogin().loginPage("/login").permitAll()
    .and()
    .logout().permitAll();