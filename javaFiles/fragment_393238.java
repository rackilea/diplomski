private String userAccess[] = new String[]{"/dashboard/**"};
    private String dataAccess[] = new String[]{"/data/**"};
    private String adminAccess[] = new String[]{"/admin/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(publicResources).permitAll()
                .antMatchers(userAccess).hasAnyRole("USER", "DATA", "ADMIN").anyRequest().authenticated()
                .antMatchers(dataAccess).hasAnyRole("DATA", "ADMIN").anyRequest().authenticated()
                .antMatchers(adminAccess).hasRole("ADMIN").anyRequest().authenticated();
    }