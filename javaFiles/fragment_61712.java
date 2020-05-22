public class PublishingAuthorizationServerSecurityConfiguration
    extends AuthorizationServerSecurityConfiguration {

    @Autowired
    AuthenticationEventPublisher authenticationEventPublisher;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.getSharedObject(AuthenticationManagerBuilder.class)
            .authenticationEventPublisher
                (authenticationEventBuilder);
    }
}