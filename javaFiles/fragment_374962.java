public Route createRoute(ActorSystem system) {
  return path("ws", () -> {
    ConsumerSettings<byte[], String> consumerSettings = ConsumerSettings.create(system, new ByteArrayDeserializer(), new StringDeserializer())
      .withBootstrapServers("localhost:9092")
      .withGroupId(UUID.randomUUID().toString()) //this is so that each client gets all messages. To be able to resume from where a client left off in case of disconnects, you can generate in on the client side and pass in the request
      .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

    return handleWebSocketMessages(
      Flow.fromSinkAndSourceCoupled(
        Sink.ignore(),
        Consumer.committableSource(consumerSettings, Subscriptions.topics("topic1"))
          .map(msg -> TextMessage.create(msg.record().value()))
      )
    );
  }
}