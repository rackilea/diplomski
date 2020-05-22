public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    private int a, b;

    public Producer(BlockingQueue<Integer> queue, int a, int b) {
        this.queue = queue;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = a; i <= b; i++){
            try {
                //producer will wait here if there is no space in the queue
                queue.put(i);
                System.out.println("Put: " + i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;
    public boolean finish = false;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!finish || queue.size() > 0) {
                // consumer will wait here if the queue is empty;
                // we have to poll with timeout because several consumers may pass 
                // here while queue size is less than number of consumers;
                // timeout should be at least equal to producing interval
                Integer temp = queue.poll(3, TimeUnit.SECONDS);
                if (temp != null) {
                    System.out.println("Took: " + temp);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}