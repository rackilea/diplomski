class HTTPRequestClient {

    private HTTPRequest httpRequest = HttpRequestFactory.getHttpRequest();

    public void callServer(){
        httpRequest.getRequest("http://someurl.com/");
    }

    void setHttpRequest(HTTPRequest httpRequest){
        this.httpRequest = httpRequest;
     }
  }

class HTTPRequestFactory {
   private static final HttpRequest httpRequest = new HttpRequest();

   public static HTTPRequest getHttpRequest() {
     return httpRequest;
   }
}

class HTTPRequestClientTest {
     HTTPRequestClient  httpRequestClient;

       @Before
       public void setUp(){
           httpRequestClient = new HTTPRequestClient();
           httpRequestClient.setHttpRequest(new HttpRequestMock());
        }

        @Test
        ...
      }