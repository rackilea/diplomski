public class HttpCommand extends HystrixCommand<HttpResponse> {

  private final HttpClient httpClient;
  private final HttpRequestBase request;

  public HttpCommand(String commandKey, HttpClient httpClient, HttpRequestBase request) {
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HttpGroup"))
        .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey)));
    this.httpClient = httpClient;
    this.request = request;
  }

  @Override
  protected HttpResponse run() throws Exception {
    return httpClient.execute(request);
  }

}