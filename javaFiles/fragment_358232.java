class AuthenticatorFactory {

    private AuthenticatorFactory(){}

    //type of param may be enum or other
    public static Authenticator createAuthenticator(... param) {
        if (param == ...) {
            return new URLAuthenticator();
        } else if (param == ...) {
            return new HTTPClientAuthenticator();
        }
    }
}