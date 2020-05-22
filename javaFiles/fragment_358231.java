AuthenticationHandler handler = new AuthenticationHandlerImpl();
Authenticator authenticator = new HTTPClientAuthenticator();
//or
//Authenticator authenticator = new URLAuthenticator();
authenticator.setLogin(...);
authenticator.setPassword(...);
handler.setAuthenticator(authenticator)

handler.authenticate();