public static Promise<Result> index() {

    final Promise<Result> resultPromise = WS.url("http://google.com").get().map(echo);

    return resultPromise;

}