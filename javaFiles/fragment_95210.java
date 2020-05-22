public class SyncExample {

    private static Object objToSync = new Object();

    public static final void main(String[] args) {
        Thread second;

        System.out.println("Main thread acquiring lock");
        synchronized (objToSync) {
            System.out.println("Main thread has lock, spawning second thread");
            second = new Thread(new MyRunnable());
            second.start();
            System.out.println("Main thread has started second thread, sleeping a moment");
            try {
                Thread.currentThread().sleep(250);
            }
            catch (Exception e) {
            }
            System.out.println("Main thread releasing lock");
        }
        System.out.println("Main thread sleeping again");
        try {
            Thread.currentThread().sleep(250);
        }
        catch (Exception e) {
        }
        System.out.println("Main thread waiting for second thread to complete");
        try {
            second.join();
        }
        catch (Exception e) {
        }
        System.out.println("Main thread exiting");
    }

    static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("Second thread running, acquiring lock");
            synchronized (objToSync) {
                System.out.println("Second thread has lock, sleeping a moment");
                try {
                    Thread.currentThread().sleep(250);
                }
                catch (Exception e) {
                }
                System.out.println("Second thread releasing lock");
            }
            System.out.println("Second thread is done");
        }
    }
}