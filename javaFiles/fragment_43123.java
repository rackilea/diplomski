package test.messaging;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProducerConsumers {

    static Broker broker;

    public TestProducerConsumers(int maxSize) {
        broker = new Broker(maxSize);
        Producer p = new Producer();
        Consumer c1 = new Consumer("One");
        broker.consumers.add(c1);
        c1.start();

        Consumer c2 = new Consumer("Two");
        broker.consumers.add(c2);
        c2.start();

        p.start();
    }

    // Test Producer, use your own message producer on a thread to call up
    // broker.insert() possibly passing it the message instead.
    class Producer extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    broker.insert();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        String myName;
        LinkedBlockingQueue<String> queue;

        Consumer(String m) {
            this.myName = m;
            queue = new LinkedBlockingQueue<String>();
        }

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                try {
                    while (queue.size() == 0 && !Thread.interrupted()) {
                        ;
                    }
                    while (queue.peek() == null && !Thread.interrupted()) {
                        ;
                    }
                    System.out.println("" + myName + " Consumer: " + queue.poll());
                } catch (Exception e) { }
            }
        }
    }

    class Broker {
        public ArrayList<Consumer> consumers = new ArrayList<Consumer>();

        int n;
        int maxSize;

        public Broker(int maxSize) {
            n = 0;
            this.maxSize = maxSize;
        }

        synchronized void insert() throws InterruptedException {
                    // only here for testing don't want it to runaway and 
                    //memory leak, only testing first 100 samples.
            if (n == maxSize)
                wait();
            System.out.println("Producer: " + n++);
            for (Consumer c : consumers) {
                c.queue.add("Message " + n);
            }
        }

    }

    public static void main(String[] args) {
        TestProducerConsumers pc = new TestProducerConsumers(100);

    }
}