public class Thread1 implements Runnable {
    private final BlockingQueue queue;
    public Thread1(BlockingQueue queue) { this.queue = queue; }
    public void run() {
        for(int i=0; i<=10; i++) {
            try {
                queue.put(i+2);
                System.out.println("Thread 1");
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Thred2  implements Runnable {
    private final BlockingQueue queue;
    public Thred2(BlockingQueue queue) { this.queue = queue; }
    public void run() {
        for(int i=0; i<=10; i++) {
            try {
                System.out.println("Thread 2" + queue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Thred2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Thread1(queue));
        Thread t2 = new Thread(new Thred2(queue));
        t1.start();
        t2.start();
    }
}