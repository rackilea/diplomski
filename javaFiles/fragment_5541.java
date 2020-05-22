public class GroupLister {
    static HttpTransport transport = new NetHttpTransport();
    static HttpParser parser = new AtomParser(new XmlNamespaceDictionary());

    public GroupFeed listGroups(String domainName, String apiKey,
            String username, String password) throws IOException {
        HttpRequestFactory factory = createRequestFactory(transport, username,
                password);
        GoogleUrl url = new GoogleUrl(
                "https://apps-apis.google.com/a/feeds/group/2.0/" + domainName);
        url.key = apiKey;
        return factory.buildGetRequest(url).execute().parseAs(GroupFeed.class);
    }

    public HttpRequestFactory createRequestFactory(
            final HttpTransport transport, final String username,
            final String password) {
        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
                request.addParser(parser);
                ClientLogin authenticator = new ClientLogin();
                authenticator.transport = transport;
                authenticator.authTokenType = "apps";
                authenticator.username = username;
                authenticator.password = password;
                request.getHeaders().setAuthorization(
                        authenticator.authenticate()
                                .getAuthorizationHeaderValue());
            }
        });
    }

}