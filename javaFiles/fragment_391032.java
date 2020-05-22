public class Notifier {

   public Mono<Void> sendNotification (MyEvent event) {
      log.info("notifier sendNotification " + event.getValue());
      return Mono.just(event)
                 .filter(e -> /* your condition */)
                 .flatMap(e -> WebClient.builder().baseUrl("XXX")...)
                 .then();
   }

}