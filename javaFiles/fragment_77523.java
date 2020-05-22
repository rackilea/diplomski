@Override
public Receive createReceive() {
  return receiveBuilder()
    .match(WhoToGreet.class, wtg -> {
      this.greeting = message + ", " + wtg.who;
    })
    .match(Greet.class, x -> {
      printerActor.tell(new Greeting(greeting), getSelf());
    })
    .match(PrinterAck.class, x -> {
      log.info("Received an ack from the printer actor.");
    })
    .build();
}