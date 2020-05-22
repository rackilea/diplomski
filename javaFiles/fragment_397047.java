@Override
protected void configure( HttpSecurity http ) throws Exception
{

    http.csrf().disable()

            .authorizeRequests()

            .antMatchers("/rest/noauth/**").permitAll()

            .antMatchers("/rest/login").permitAll()

            .antMatchers("/rest/logout").permitAll()

            .antMatchers("/src/**").permitAll()

            .antMatchers("/v2/api-docs/**", "/configuration/ui/**", "/swagger-resources/**",
                    "/configuration/security/**", "/swagger-ui.html/**", "/webjars/**")
            .permitAll()

            .anyRequest().authenticated()

            .and()

            .logout().addLogoutHandler(logoutHandler).logoutSuccessHandler(logoutSuccessHandler)
            .logoutUrl("/rest/logout")

            .and()

            .addFilterBefore(
                    new JWTAuthenticationFilter("/rest/login",
                    UsernamePasswordAuthenticationFilter.class)

            .addFilterBefore(new JWTAuthorizationFilter(authenticationManager(), authTokenModelRepository),
                    UsernamePasswordAuthenticationFilter.class);

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

}