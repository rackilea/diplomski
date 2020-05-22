@Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{

        ......
        ......
        ......

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/freerest/**").permitAll()
                        .anyRequest().hasAnyAuthority("USER")
                    .and()
                    .httpBasic();
        }

        ......
        ......
        ......

    }