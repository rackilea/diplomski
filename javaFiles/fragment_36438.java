public class BasicAuthInjectable extends AbstractHttpContextInjectable<User>{

    @Override
    public User getValue(HttpContext hc) {
        String authHeaderValue = hc.getRequest()
                .getHeaderValue(HttpHeaders.AUTHORIZATION);
        String[] credentials = ImosUtils.getUserCredentials(authHeaderValue);

        return new User(credentials[0], credentials[1]);
    }  
}