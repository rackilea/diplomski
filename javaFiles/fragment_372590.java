@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Other configurations

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Other configurations
                .headers()
                    .cacheControl().disable();
    }
}