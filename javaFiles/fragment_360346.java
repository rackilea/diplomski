public class TestOne extends Thread {
    public static void main (String[] args) throws Exception {
        Thread t = new Thread (new TestOne());
        t.start();

        Thread.sleep (1000);  // <- Added this.

        System.out.println ("Started");
        t.join();
        System.out.println ("Complete");
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println (i);
        }
    }
}