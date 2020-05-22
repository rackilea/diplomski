public class HttpClientFactoryBean{
    private HttpClient httpClient;
    public HttpClientFactoryBean(HttpClient httpClient, Credentials credentials){
        this.httpClient = httpClient;
        httpClient.getState().setCredentials(AuthScope.ANY, credentials);
    }

    public HttpClient getHttpClient(){
        return httpClient;
    }
}