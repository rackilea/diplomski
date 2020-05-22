public class HTTPRequestMock extends HttpRequest {

    @Override
    protected CloseableHttpClient getHttpClient() {
      //return mock
      return new CloseableHttpClientMock();
    }

    @Override
    protected HttpGet getHttpGet(String url) {
      //return mock
      return new HttpGetMock(url);
    }

    @Override
    protected HttpPost getHttpPost(String url) {
      //return mock
      return new HttpPostMock(url);
    }

    ...
}