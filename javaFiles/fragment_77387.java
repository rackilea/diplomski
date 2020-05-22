public static Promise<Result> foo(){
  return WS.url(GoogleStrategy.getTokenUrl).post(getTokenUrlParams).map(
    new F.Function<WSResponse, Result>() {
      @Override
      public Object apply(WSResponse wsResponse) throws Throwable {
        return ok(wsResponse.asJson());
      }
    }
  );
}