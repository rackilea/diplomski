public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //Produce 1000 products
        for (int i = 0; i < 1000; i++) {
            queue.put(new Product());
            System.out.println("PRODUCED PRODUCT");
        }
    }
}
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Product product = queue.take();
            System.out.println("CONSUMED PRODUCT");
        }
    }
}

And here is the calling code:
BlockingQueue queue = new ArrayBlockingQueue(50);

Producer producer = new Producer(queue);
new Thread(producer).start();

Consumer consumer = new Consumer(queue);
new Thread(consumer).start();