Connection conn = yourconnection; // the connection your listener will use
Destination dest = yourdestination; // the destination you're paying attention to
ConsumerEventSource source = new ConsumerEventSource(conn, dest);
source.setConsumerListener(new ConsumerListener() {

   public void onConsumerEvent(ConsumerEvent event) {
      if (event.isStarted()) {
         System.out.println("a new consumer has started - " + event.getConsumerId());
      } else {
         System.out.println("a consumer has dropped - " + event.getConsumerId());
      }
   }

});