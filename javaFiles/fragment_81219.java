http
     .authorizeRequests()                                                                
     .antMatchers("/resources/**", "/login").permitAll()   
     .antMatchers("/admin/**").hasRole("ADMIN")
     .and()

     .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/admin/home")
        .failureUrl("/loginfailed")             
        .permitAll()
        .and()

    .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .deleteCookies("JSESSIONID")
        .invalidateHttpSession( true )
        .and();