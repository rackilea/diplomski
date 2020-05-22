protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()                                                                
            .antMatchers("/resources/**", "/signup", "/about").permitAll()                  
            .antMatchers("/admin/**").hasRole("ADMIN")                                      
            .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
            .anyRequest().authenticated()                                                   
            .and()
        // ...
        .formLogin();
}