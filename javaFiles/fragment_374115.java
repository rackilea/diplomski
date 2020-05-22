@Bean
public AuthenticationEntryPoint delegatingEntryPoint() {
    final LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> map = new LinkedHashMap();
    map.put(new AntPathRequestMatcher("/"), new LoginUrlAuthenticationEntryPoint("/login"));
    map.put(new AntPathRequestMatcher("/api_v1/**"), new Http403ForbiddenEntryPoint());

    final DelegatingAuthenticationEntryPoint entryPoint = new DelegatingAuthenticationEntryPoint(map);
    entryPoint.setDefaultEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));

    return entryPoint;
}

@Override
protected void configure(HttpSecurity http) throws Exception {

    //delegates based on url (api vs root)
    http.exceptionHandling().authenticationEntryPoint(delegatingEntryPoint());

    http
        .authorizeRequests()
        .antMatchers("/css/**").permitAll()
        .anyRequest().authenticated();
    http
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/", true)
            .permitAll()
            .and()
        .httpBasic()
            .and()
        .csrf().disable()
        .logout()
            .logoutSuccessUrl("/login");
}