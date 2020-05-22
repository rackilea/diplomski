public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue) {
       this.queue = queue;
    }
    @Override
    public void run() {
       while (true) {
          int consumedData = queue.take();
          if (consumedData ==  Producer.FINAL_VALUE) {
              logger.info("Consumed: END (end of data production token).");
              break;
          }
          logger.info("Consumed: {}.", consumedData);
       }
       logger.info("Signing off.");
    }
}

public class Producer implements Runnable {
    public static final int FINAL_VALUE = -1;
    private final BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue) {
       this.queue = queue;
    }
    @Override
    public void run() {
       for (int nIterations = 0; nIterations <= N_ITERATIONS; nIterations++) {
          logger.info("Produced: {}", nIterations);
          queue.put(nIterations);
       }
       queue.put(FINAL_VALUE);
       logger.info("Produced: END (end of data production token).");
       logger.info("Signing off.");
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
       // you can add an int argument to the LinkedBlockingQueue constructor
       // to only allow a certain number of items in the queue at one time
       BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
       Thread producer = new Thread(new Producer(queue), "Producer");
       Thread consumer = new Thread(new Consumer(queue), "Consumer");
       // start and join go here
    }
}