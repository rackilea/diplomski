public class Wrapper {
private AuthenticationToken authenticationToken;

public Wrapper(AuthenticationToken authenticationToken) {
    this.authenticationToken = authenticationToken;
}

public AuthenticationToken getAuthenticationToken() {
    return authenticationToken;
}

public void setAuthenticationToken(AuthenticationToken authenticationToken) {
    this.authenticationToken = authenticationToken;
    }
}