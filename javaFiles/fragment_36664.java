public class MainThread extends java.lang.Thread {
    final private List<BlockingQueue<Integer>> queues;
    final private AtomicInteger atomicInteger = new AtomicInteger();

    public MainThread(List<BlockingQueue<Integer>> queues) {
        this.queues = queues;
    }

    public void run() {
        while (true) {
            int temp = atomicInteger.getAndIncrement();
            for(BlockingQueue<Integer> queue : queues) {
                queue.offer(temp);
            }
        }
    }
}

public class WorkerThread extends java.lang.Thread {
    private final BlockingQueue<Integer> queue;

    public WorkerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            int temp = queue.take();
            // process temp
        }
    }
}