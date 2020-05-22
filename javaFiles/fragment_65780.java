import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        final ArrayList al = new ArrayList(6);
        al.add(0, "abc");
        al.add(1, "abc");
        al.add(2, "abc");

        // Start a thread that notifies al after one second.
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (al) {
                    al.notify();      // <-- this "releases" the wait.
                }
            }
        }.start();

        synchronized (al) {
            System.out.println("Before wait");
            al.wait();
            System.out.println("After wait");
        }
    }
}