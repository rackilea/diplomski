public class DeadLockUsingJoins2 {
    public static boolean go;

    public synchronized static void main(String[] args)
            throws InterruptedException {
        AThread a = new AThread(null, "A");
        AThread b = new AThread(a, "B");
        a.start();
        while (!go) {
            DeadLockUsingJoins2.class.wait();
        }
        a.t = b;
        b.start();
        DeadLockUsingJoins2.class.notifyAll();
    }
}

class AThread extends Thread {
    public Thread t;

    public AThread(Thread thread, String name) {
        super(name);
        this.t = thread;
    }

    @Override
    public void run() {
        try {
            if (t != null)
                t.join();
            else {
                synchronized (DeadLockUsingJoins2.class) {
                    DeadLockUsingJoins2.go = true;
                    DeadLockUsingJoins2.class.notifyAll();
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Winding Up thread - " + this.getName());
    }