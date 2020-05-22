class YourTestCase extends SeleneseTestCase {
    public class MyRunnable implements Runnable {
        public void run() {
            // Do your have work here
        }
    }

    public void testMethodToExecuteInThread() {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
    }
}