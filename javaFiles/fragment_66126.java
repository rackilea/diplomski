public class AuthTypeAndScopeInfo {

    /* adds grant type and scope as body to message */
    public MultiValueMap<String, String> getGrantTypeAndScope() {
        // Create the request body as a MultiValueMap
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

        body.add("grant_type", "client_credentials");
        body.add("scope", "read");

        return body;
    }
}