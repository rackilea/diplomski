public class ProducerConsumerRunnable implements Runnable {
      private final Processor processor;
      private final boolean consume;
      public ProducerConsumerRunnable(Processor processor, boolean consume) {
          this.processor = processor;
          this.consume = consume;
      }
      public void run() {
          if (consume) {
              processor.consume()
          } else {
              processor.produce()
          }
      }
 }