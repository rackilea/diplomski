@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfiguration {

    /**
     * Development security configuration.
     */
    @Profile("dev")
    @Configuration
    public static class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean userIdAuthenticationFilter() {
            // ...
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.apply(commonSecurityConfiguration())
                    .and().addFilter(userIdAuthenticationFilter().getFilter());
        }
    }

    /**
     * Production security configuration.
     */
    @Profile("!dev")
    @Order(1)
    @Configuration
    public static class ProdSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean jwtAuthenticationFilter() {
            // ...
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.apply(commonSecurityConfiguration())
                    .and().addFilter(jwtAuthenticationFilter().getFilter());
        }
    }


    /**
     * Common security configuration reused by all profiles.
     */
    public static class CommonSecurityConfiguration
            extends AbstractHttpConfigurer<CommonSecurityConfiguration, HttpSecurity> {

        @Override
        public void init(HttpSecurity http) throws Exception {
            // Your basic configuration here:
            // http.cors().and()
            // ...
        }

        public static CommonSecurityConfiguration commonSecurityConfiguration() {
            return new CommonSecurityConfiguration();
        }
    }
}