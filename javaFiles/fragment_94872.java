public class Main {

    public static void main (String[] args) {

        // Counter object to be shared between two threads:
        Counter counter = new Counter();

        // Instantiation of Threads:
        Thread counterThread1 = new Thread(new CounterThread("A",counter), "counterThread1");
        Thread counterThread2 = new Thread(new CounterThread("B",counter), "counterThread2");

        counterThread1.start();
        counterThread2.start();
    }
}

 class Counter {

    long count = 0;

    // Adding a value to count data member:
    public synchronized void add (String label, long value) {
        System.out.println(label+ " BEFORE add - " + Thread.currentThread().getName() + ": " + this.count);
        this.count += value;
        System.out.println(label+ " AFTER add - " + Thread.currentThread().getName() + ": " + this.count);
    }

    public synchronized long getValue() {
        return count;
    }
}

class CounterThread implements Runnable {

    private String label;
    protected Counter counter = null;

    public CounterThread(String label, Counter aCounter) {
        this.label = label;
        this.counter = aCounter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(label, 1);
        }
    }
}