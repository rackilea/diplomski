public class Application extends Controller {

  public static Result timeout() throws Exception {
    int timeout = 2000;
    Thread.sleep(timeout);

    return ok(format("Just give me %d seconds!", timeout / 1000));
  }

  public static Promise<Result> takeSomeTime() throws Exception {

    return couldBeAWhile().map(new F.Function<String, Result>() {

      @Override
      public Result apply(final String body) throws Throwable {
        return ok(body);
      }
    });
  }

  public static Promise<String> couldBeAWhile() {
    Promise<WSResponse> response = WS.url("http://localhost:9000/timeout")
        .setTimeout(1000)
        .get();

  Promise<String> promise = response.map(new F.Function<WSResponse, String>() {

    @Override
    public String apply(final WSResponse wsResponse) throws Throwable {
      return wsResponse.getBody();
    }

  });

  promise = promise.recover(new F.Function<Throwable, String>() {

    public String apply(Throwable t) throws Throwable {
      Logger.error("Error ->", t);
      return "error";
    }
  });

  return promise;
}