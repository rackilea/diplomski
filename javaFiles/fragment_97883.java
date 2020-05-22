@Configuration
@Profile("prod")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**/import").hasRole("ADMINISTRATOR")
                .antMatchers("/api-docs/**", "/swagger-resources/**", "/v2/api-docs", "/**/favicon.ico", "/webjars/**", "/api/admin/health").permitAll()
                .anyRequest().authenticated()
                //replace .permitAll() with .authenticated() for authentiaction
                //replace .authenticated() with .permitAll() for disabling security
                .and()
                .csrf().disable()
                .headers().disable()
                .httpBasic();
    }
}


@Configuration
@Profile("test")
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/**/import").hasRole("ADMINISTRATOR")
                .antMatchers("/api-docs/**", "/swagger-resources/**", "/v2/api-docs", "/**/favicon.ico", "/webjars/**", "/api/admin/health").permitAll()
                .anyRequest().permitAll()
                //replace .permitAll() with .authenticated() for authentiaction
                //replace .authenticated() with .permitAll() for disabling security
                .and()
                .csrf().disable()
                .headers().disable()
                .httpBasic();
    }
}