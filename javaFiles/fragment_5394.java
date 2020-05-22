public void onApplicationEvent(ApplicationEvent event) {

    if (event instanceof AuthenticationSuccessEvent) {

        try {

            AuthenticationSuccessEvent authenticationSuccessEvent = (AuthenticationSuccessEvent) event;

            Authentication authentication = authenticationSuccessEvent.getAuthentication();

            //Persist your user's login here.

        } catch (Exception e) {

            // Handle exception as needed.
        }
    }
}