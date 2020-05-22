int bufferSize = 10;
FluxProcessor<String, String> processor =
    EmitterProcessor.<String>create(bufferSize).serialize();
FluxSink<String> sink = processor.sink(FluxSink.OverflowStrategy.BUFFER);

sink.next("1");
sink.next("2");
sink.next("3");

WebSocketClient webSocketClient = new ReactorNettyWebSocketClient();
webSocketClient.execute(new URI("wss://echo.websocket.org"),
    session -> {
      Flux<WebSocketMessage> out = Flux.just("INIT")
          .concatWith(processor)
          .map(session::textMessage);

      session.send(out)
          .subscribe(); //instead of thenMany

      return session.receive()
          .map(WebSocketMessage::getPayloadAsText)
          .map(s -> "Received: " + s)
          .log()
          .then();
    })
    .subscribe();

for (int i = 1; i <= 10; i++) {
  sink.next("MSG #" + i);
  TimeUnit.SECONDS.sleep(1);
}
sink.complete();