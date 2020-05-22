@Component
class SuccessfulAuthenticationListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        // Put the function which is automatically invoked immediately 
        // after acceptance of the request as authorized.
    }
}