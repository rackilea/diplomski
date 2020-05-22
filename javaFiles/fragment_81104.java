@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    public SecurityConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Profile("dev")
    @Bean
    public FilterRegistrationBean userIdAuthenticationFilter() {
        // ...
    }

    @Profile("!dev")
    @Bean
    public FilterRegistrationBean jwtAuthenticationFilter() {
        // ...
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your basic configuration here:
        // http.cors().and()
        // ...

        if (environment.acceptsProfiles("dev")) {
            http.addFilter(userIdAuthenticationFilter().getFilter());
        } else {
            http.addFilter(jwtAuthenticationFilter().getFilter());
        }
    }
}