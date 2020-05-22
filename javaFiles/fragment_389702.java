public class TestClass {

    private BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.executeProducerConsumer(3, 3);
    }

    public void executeProducerConsumer(int producerCount, int consumerCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(producerCount + consumerCount, Executors.defaultThreadFactory());

        for (int i = 0; i < producerCount; i++) {
            executorService.submit(new Producer(sharedQueue));      //producer
        }

        for (int i = 0; i < consumerCount; i++) {
            executorService.submit(new Consumer(sharedQueue));      //i-th consumer.
        }

        //initiates clossure of threads after completion, in async manner.
        executorService.shutdown();

        //wait till all threads are done.
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The End.");
    }

}

class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;
    private static volatile boolean isProducerClosed = false; // make this static so that it is shared across consumers

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
            Integer value;

            while (!isProducerClosed) {
                try {
                    synchronized (queue) { //synchronize so that only one thread can talk to the queue at a time
                        if (!isProducerClosed) { //double check
                            value = queue.take(); // we can now safely take an item
                            if ((value.intValue() == -1)) {
                                isProducerClosed = true;
                                System.out.println(Thread.currentThread().getName() + " Encountered -1. Signal to shutdown consumers.");
                                break;
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + " Last item was taken by some other consumer. Exiting!");
                            break;
                        }
                    }
                    consumeValue(value); //Consume the value outside the lock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void consumeValue(Integer value) {
        System.out.println(Thread.currentThread().getName() + " Consuming value :" + value);
    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private static volatile int maxNumberOfItemsToProduce = 10;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {

            if (maxNumberOfItemsToProduce == 0) {
                try {
                    queue.put(-1);
                    System.out.println("Terminating Producer after producing max number of products.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            try {
                queue.put(random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            maxNumberOfItemsToProduce--;
        }

    }
}