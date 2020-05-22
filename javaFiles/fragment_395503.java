@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    @SuppressWarnings("unchecked")
    protected void configure(HttpSecurity http)
            throws Exception {

        http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .csrf()
                .disable()
            .authorizeRequests()
                .expressionHandler(securityExpressionHandler)
                .antMatchers("/asset/**").access("permitAll")
                .antMatchers("/ws/ssoEnabled").access("permitAll")
                .antMatchers("/**").access("hasRole('ROLE_USER') or hasRole('ROLE_TOKEN_ACCESS')")
                .and()
            .httpBasic()
                .authenticationEntryPoint(ajaxAwareLoginUrlAuthenticationEntryPoint)
                .and()

            // OAuth filters
            // Explicitly add a RequestContextFilter ahead of the Oauth filters to facilitate retrieval of a session-scoped oauth2ClientContext object
            .addFilterAfter(requestContextFilter, SecurityContextPersistenceFilter.class)
            // Handles unauthenticated requests, catching UserRedirectRequiredExceptions and redirecting to OAuth provider
            .addFilterAfter(oAuth2ClientContextFilter, RequestContextFilter.class)
            // Handles the oauth callback, exchanging the one-time code for a durable token
            .addFilterAfter(openIdConnectFilter, OAuth2ClientContextFilter.class)

            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(ajaxAwareAuthenticationSuccessHandler)
                .failureHandler(ajaxAwareAuthenticationFailureHandler)
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and()
            .rememberMe()
                .rememberMeServices(rememberMeServices)
                // Even though this key has been added directly to the rememberMeServices instance, the RememberMeConfigurer
                // can instantiate a new RememberMeServices with a made-up key if the same key is not provided.
                .key("the key value")
        ;

        // We do not configure a bean for the SessionAuthenticationStrategy. We want to use the Spring default strategy,
        // which is configured by the above builder chain. In order to share the correct, configured instance with our
        // custom OpenIdConnectFilter, we first tell the builder to perform the configuration (normally this would be
        // done long after this method returns)...
        http.getConfigurer(SessionManagementConfigurer.class).init(http);
        // ... then we get the shared object by interface (SessionAuthenticationStrategy) class name...
        final SessionAuthenticationStrategy sessionAuthenticationStrategy = http.getSharedObject(SessionAuthenticationStrategy.class);
        // ... then set it in our custom filter.
        openIdConnectFilter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy);
    }
}