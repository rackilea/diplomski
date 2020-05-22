public int attemptWinkHttpClienGET() {
    ClientResponse response = null;
    try {
        String spUri = "https://some-sharepoint-url/listdata.svc/";

        StringBuilder sb = new StringBuilder();
        sb.append(spUri).append("UserInformationList").toString();

        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getAuthSchemes().register("ntlm",new JCIFSNTLMSchemeFactory());
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        NTCredentials ntcred = new NTCredentials("username_here", "password_here", InetAddress.getLocalHost().getHostName(), "domain_here");
        credsProvider.setCredentials(new AuthScope("base_url_here_sans_https://", 443, AuthScope.ANY_REALM, "NTLM"), ntcred);
        httpClient.setCredentialsProvider(credsProvider);

        org.apache.wink.client.ClientConfig httpClientConfig = new org.apache.wink.client.ApacheHttpClientConfig(httpClient);
        Application app = new Application() {
            public Set<Class<?>> getClasses() {
                Set<Class<?>> classes = new HashSet<Class<?>>();
                classes.add(WinkMOXyJsonProvider.class);
                return classes;
            }
        };
        httpClientConfig.applications(app);
        RestClient client = new RestClient(httpClientConfig);
        Resource resource = client.resource(sb.toString());
        response = resource.accept(MediaType.APPLICATION_JSON_TYPE).get();
        UserInformationListResponse blah = response.getEntity(UserInformationListResponse.class);
        Results[] results = blah.getD().getResults();
        for (Results result : results) {
            System.out.println("User Name: " + result.getFirstName() + " " + result.getLastName());
        }
        System.out.println("The response is " + response.getStatusCode());
        response.consumeContent();
    } catch (UnknownHostException ex) {
        Logger.getLogger(HttpTest.class.getName()).log(Level.SEVERE, null, ex);
    }

    return response.getStatusCode();
}