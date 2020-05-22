@Override
public Mono<Void> handle(WebSocketSession session) {

    return session.send(
       session.receive()
              .flatMap(webSocketMessage -> {
                  int id = Integer.parseInt(webSocketMessage.getPayloadAsText());

                  Flux<EfficiencyData> flux = service.subscribeToEfficiencyData(id);
                  var publisher = flux
                      .<String>handle((o, sink) -> {
                         try {
                            sink.next(objectMapper.writeValueAsString(o));
                         } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            return; // null is prohibited in reactive-streams
                         }
                      })
                      .map(session::textMessage)
                      .delayElements(Duration.ofSeconds(1));

                  return publisher;
              })
    );
}