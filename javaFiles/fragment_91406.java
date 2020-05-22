@Test
void invalidUrlTest(Vertx vertx, VertxTestContext ctx) {
    Async async = ctx.async();
    HttpClient client = vertx.createHttpClient();
    client.get(8080,"localhost","/someinvalidaddress/")
      .exceptionHandler(ex -> {
        assertThat(meterRegistry.counter("invalid.request.counter")).isEqualTo(1.0);
        async.complete();
      }).end();
}