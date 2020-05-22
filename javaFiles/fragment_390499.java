public static HttpResponse handleRequest(HttpRequest request) {
  HttpResponse result;
  if (request.getUri().path().equals("/greeter")) {
    final Flow<Message, Message, NotUsed> greeterFlow = greeter().watchTermination((nu, cd) -> {
      connections.incrementAndGet();
      cd.whenComplete((done, throwable) -> connections.decrementAndGet());
      return nu;
    });
    result = WebSocket.handleWebSocketRequestWith(request, greeterFlow);
  } else {
    result = HttpResponse.create().withStatus(413);
  }
  return result;
}