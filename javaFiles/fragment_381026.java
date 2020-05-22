public class ConnnectionTestWithHTTPClient {

    public static void main(String[] args) throws URISyntaxException, IOException {


        String host = "https://rally1.rallydev.com";
        String apiKey = "_abc123";
        String applicationName = "Connnection Test With HTTPClient";
        RallyRestApi restApi = new RallyRestApi(new URI(host),apiKey);
        restApi.setApplicationName(applicationName); 
        //restApi.setProxy(new URI("http://myproxy.mycompany.com"), "MyProxyUsername", "MyProxyPassword");  //YOUR PROXY SETTINGS HERE
        HttpClient client = restApi.getClient();
        try {
            SSLSocketFactory sf = new SSLSocketFactory(new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] certificate, String authType)
                    throws CertificateException {
                    //trust all certs
                    return true;
                }
            }, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            client.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, sf));

            String workspaceRef = "/workspace/12345"; 
            GetRequest getRequest = new GetRequest(workspaceRef);
            GetResponse getResponse = restApi.get(getRequest);
            System.out.println(getResponse.getObject());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            restApi.close();
        }   
    } 
}