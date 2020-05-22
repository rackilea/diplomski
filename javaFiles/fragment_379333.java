@Order(1)
@Configuration
private static class ApiSecurityConfigurationAdapter
        extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and.httpBasic().authenticationEntryPoint(xBasicAuthenticationEntryPoint)
            .and.authorizeRequests()
                .anyRequest().authenticated();
    }
}

@Configuration
private static class NormalSecurityConfigurationAdapter
        extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(switchUserFilter())
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/static/**").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
                  .loginPage("/login")
                  .permitAll()
                  .defaultSuccessUrl("/")
            .and().logout()
                  .logoutUrl("/logout")
                  .logoutSuccessUrl("/");
    }
}