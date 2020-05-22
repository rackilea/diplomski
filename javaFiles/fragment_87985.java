import java.io.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String args[]) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        Thread th = new Thread(new Read(queue));
        Thread pr = new Thread(new Echo(queue));
        th.start();
        pr.start();
    }
}

class Read implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Read(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try (FileReader fr = new FileReader("data.txt")) {
            for (;;) {
                int c = fr.read();
                queue.put(c);
                if (c == -1) break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Echo implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Echo(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (;;) {
                int c = queue.take();
                if (c == -1) break;
                System.out.println("From echo int " + c + " char value " + (char)c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}