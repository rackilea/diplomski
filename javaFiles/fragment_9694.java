public class Child2 implements Runnable {
    Object mutex;

    public Child2(Object mutex) {
        this.mutex = mutex;
    }

    public void run() {
        synchronized (mutex) {
            for (int c = 11; c < 21; c++) {
                System.out.println(c);
            }
            mutex.notify(); // Changed here
        }

    }
}