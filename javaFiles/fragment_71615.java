private void startClient(Vertx vertx) {
  HttpClient client = vertx.createHttpClient();
  MultiMap form = MultiMap.caseInsensitiveMultiMap();
  if(MapUtils.isNotEmpty(header)) {
    header.forEach((k,v)-> {
      form.set(k, v);
    });
  }
  RequestOptions options = new RequestOptions()
     .setHost(host)
     .setPort(port)
     .setSsl(sslFlag)
     .setURI(uri);
  client.websocket(options, form, (ctx) ->{
    ctx.textMessageHandler( msg -> {
      System.out.println("Client " + msg);
    }).exceptionHandler((e) -> {
        client.close();
        vertx.setTimer(waitTime * 10 * 1000, (__) -> {
          startClient(vertx);
        });
    });
  }, (exec) -> {
      vertx.setTimer(waitTime * 10 * 1000, (__) -> {
        startClient(vertx);
      });
  });
}