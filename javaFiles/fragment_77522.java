@Override
public Receive createReceive() {
  return receiveBuilder()
    .match(Greeting.class, greeting -> {
      log.info(greeting.message);
      getSender().tell(new PrinterAck(), ActorRef.noSender());
  })
  .build();
}