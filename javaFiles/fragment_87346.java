public class Th1 implements Runnable {
    private int i = 0;

    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        while (i < 10) {
            System.out.println(name + ": " + i);
            i += 1;
        }
    }

    public static void main(String[] args) {
        Th1 t = new Th1();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();

    }
}