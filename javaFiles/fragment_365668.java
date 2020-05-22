import java.util.concurrent.ConcurrentLinkedQueue;


public class FinalQueue {

    private ConcurrentLinkedQueue<String> queue;

    public FinalQueue()
    {
        queue = new ConcurrentLinkedQueue<String>();
    }

    public synchronized void enqueue(String ipAddress)
    {
        if(!queue.contains(ipAddress))
            queue.add(ipAddress);
    }

    public String dequeue()
    {
        return queue.poll();
    }

    public String toString()
    {
        return "" + queue;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FinalQueue queue = new FinalQueue();
        queue.enqueue("1.2.3.4");
        queue.enqueue("2.3.4.5");
        queue.enqueue("1.1.1.1");
        queue.enqueue("1.2.3.4");
        System.out.println(queue.toString());
        System.out.println("Dequeue..." + queue.dequeue());
        System.out.println("Dequeue..." + queue.dequeue());
        System.out.println(queue.toString());
    }
}