@Configuration
@Order(1)
protected static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/admin/actuators/health").permitAll()
            .and()
                .antMatcher("/admin/actuators/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .httpBasic();
    }
}