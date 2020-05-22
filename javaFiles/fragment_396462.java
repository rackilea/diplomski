public class LoginController {

    private AuthenticationState authenticationState ;

    public void setAuthenticationState(AuthenticationState authenticationState) {
        this.authenticationState = authenticationState ;
    }

    @FXML
    public void login() {
        // check login:
        boolean loginSuccessful = ... ;

        authenticationState.setLoggedIn(loginSuccessful);

        // ...
    }
}