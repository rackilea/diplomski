@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
        jdbcAuthentication()
        .usersByUsernameQuery(usersQuery)
        .authoritiesByUsernameQuery(rolesQuery)
        .dataSource(dataSource)
        .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/confirm").permitAll()
        .antMatchers("/forgotpassword").permitAll()
        .antMatchers("/criminal/getAllWantedCriminal").permitAll()
        .antMatchers("/criminal/viewCriminal").permitAll()
        .antMatchers("/admin/**").hasAuthority("ADMIN")
        .antMatchers("/user/**").hasAuthority("USER")
        .anyRequest()
        .authenticated().and().csrf().disable().formLogin()
        .loginPage("/login").failureUrl("/login?error=true")
        .successHandler(this.getSuccessHandler())
        .usernameParameter("email")
        .passwordParameter("password")
        .and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/").and().exceptionHandling()
        .accessDeniedPage("/access-denied");
    }

    private AuthenticationSuccessHandler getSuccessHandler() {
        return new RoleBasedAuthenticationSuccessHandler(
                    "/user/home",
                    "/admin/home",
                    "ROLE_ADMIN"                
                );

    }