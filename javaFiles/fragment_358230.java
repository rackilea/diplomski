public class AuthenticationHandlerImpl implements AuthenticationHandler {

    private Authenticator authenticator;

    void authenticate() throws ConnectionException {
        authenticator.authenticate();
    };

    public void setAuthenticator(final Authenticator  authenticator){
        this.authenticator = authenticator;
    }

}

interface Authenticator {
    void authenticate();
    void setLogin(String login);
    void setPassword(String password);
}

class URLAuthenticator implements Authenticator {
    public void authenticate() {
        //use URLConnection
    };
}

class HTTPClientAuthenticator implements Authenticator {
    public void authenticate() {
        //use HTTPClient
    };
}