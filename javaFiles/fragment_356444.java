public class WaitNotifyTest implements Runnable {

private String threadType;
public ConsumerProducer cp;
public static volatile int i = 0;

public WaitNotifyTest(String threadType, ConsumerProducer cp) {
    this.threadType = threadType;
    this.cp = cp;
}

public static void main(String[] args) throws InterruptedException {

    ConsumerProducer cp = new ConsumerProducer();
    WaitNotifyTest test1 = new WaitNotifyTest("Consumer", cp);
    WaitNotifyTest test2 = new WaitNotifyTest("Producer", cp);

    Thread t1 = new Thread(test1);
    Thread t2 = new Thread(test2);

    t1.start();
    t2.start();
    t1.join();
    t2.join();
}

@Override
public void run() {
    while (true) {
        if (threadType.equalsIgnoreCase("Consumer")) {
            synchronized (cp) {
                try {
                    /*
                     * Consumer will wait when there is nothing to get and he will release the lock of cp.
                     * So that producer has change to go into the synchronized block.
                     */

                    if (null == cp.get()) {
                        cp.wait();
                    }
                    consume();
                    System.out.println("notify from Consumer");
                    cp.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            synchronized (cp) {
                try {
                    /*
                     * Producer only produce when there is nothing or he will wait. At the same time, he will release the lock of cp.
                     * So that consumer has chance to go into the synchronized block.
                     */
                    if (null != cp.get()) {
                        cp.wait();
                    }
                    i++;
                    produce();
                    System.out.println("notify from Producer");
                    cp.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (i == 5) {
            break;
        }

    }
}

public void consume() {
    System.out.println("getting: " + cp.get());
    cp.clearString();
}

public void produce() {
    System.out.println("Putting: Counter" + i);
    cp.put("Counter" + i);
}}