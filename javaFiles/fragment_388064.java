public class SubscriberTest {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService consumers = Executors.newSingleThreadExecutor();
        // middle producer
    final ExecutorService producers = Executors.newFixedThreadPool(
                                   Runtime.getRuntime().availableProcessors());
    // subscribed/original producer.
    for (int i = 0; i < 1000*1000; i++) {
            final String task = "I love:" + i;
            producers.execute(new MidProducer(task, consumers));
        }

        producers.shutdown();
        producers.awaitTermination(10, TimeUnit.SECONDS);
        consumers.shutdown();
        System.out.println("finally");
    }


    static class MidProducer implements Runnable {
        private final Random rand = new Random();
        private final String task;
        private final ExecutorService consumers;

        public MidProducer(String task, ExecutorService consumers) {
            this.task = task;
            this.consumers = consumers;
        }

        public void run() {
            System.out.println("Producer: " + task + " " + Thread.currentThread().getName());

            if (getStatus(task))
                consumers.execute(new Consumer(task));
        }

        private boolean getStatus(String x) {
            return rand.nextBoolean();
        }

    }

    static class Consumer implements Runnable {
        private final String task;

        private Consumer(String task) {
            this.task = task;
        }

        public void run() {
            System.out.println("Consumer: " + task + " " + Thread.currentThread().getName());
        }
    }
}