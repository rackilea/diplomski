public class RestServiceInvoker {

    private final HttpClient httpClient;

    public RestServiceInvoker(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public BusinessObject requestResource(String resourceId) {
        HttpResponse response = this.httpClient.sendRequest(
                RequestMethod.GET, "/data/resources/" + resourceId);
        // ... more code goes here to process the response into a BusinessObject ...
        return businessObject;
    }

}