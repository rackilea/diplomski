public class HTTPRequest {

    public HTTPResponse getRequest(url) {
        //Do some processing with httpClient & httpGet to send the request
      getHttpGet(url).call();
    }

    protected CloseableHttpClient getHttpClient() {
      return new CloseableHttpClient();
    }

    protected HttpGet getHttpGet(String url) {
      return new HttpGet(url);
    }

    protected HttpPost getHttpPost(String url) {
      return new HttpPost(url);
    }

    ...
}