import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

private Queue<Integer>      queue   = new ArrayBlockingQueue<>(10);
private LinkedList<Integer> list    = new LinkedList<>();
int                         limit   = 10;

public static void main(String[] args) {

    final ProducerConsumer pc = new ProducerConsumer();
    final ProducerConsumer pcRef = pc;

    Thread producer = new Thread(new Runnable() {
        int i = 1;

        @Override
        public void run() {
            while (true) {
                synchronized (pcRef) {
                    while (pc.limit == pc.list.size()) {
                        try {
                            pcRef.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    pc.list.add(i);
                    System.out.println("Producer @work : " + pc.list.size());
                    pcRef.notify();
                }

            }
        }
    });

    Thread consumer = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                synchronized (pc) {
                    while (0 == pc.list.size()) {
                        try {
                            pc.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int val = pc.list.removeFirst();
                    System.out.println("Consumer @work : " + pc.list.size() + " : " + val);
                    pc.notify();
                }

            }
        }
    });

    producer.start();
    consumer.start();

    try {
        producer.join();
        consumer.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}

}