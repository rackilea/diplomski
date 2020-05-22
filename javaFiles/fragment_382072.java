@Configuration
@EnableWebSecurity
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();

        // anything that is NOT /admin/**
        RequestMatcher requestMatcher = new NegatedRequestMatcher(new AntPathRequestMatcher("/admin/**", "GET"));

        // MyCustomFilter is my class that performs custom authentication logic
        http.requestMatcher(requestMatcher)
            .addFilterAfter(new MyCustomFilter(), BasicAuthenticationFilter.class);
    }


    @Order(1)
    @Configuration
    public static class AdminServiceConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //this time anything that IS /admin/**
            http.requestMatchers()
                .antMatchers("/admin/**").and()
                .httpBasic().and()
                .authorizeRequests().antMatchers("/admin/**").fullyAuthenticated();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
            authBuilder.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("username")
                .password("password")
                .roles("ADMIN");
        }
    }
}