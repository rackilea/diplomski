public static Promise<Result> index() {

    final Promise<Result> resultPromise = WS.url("http://google.com").get().map(
        new Function<WS.Response, Result>() {
            public Result apply(WS.Response response) {
                return ok(response.asText());
            }
        }
    );

    return resultPromise;
}