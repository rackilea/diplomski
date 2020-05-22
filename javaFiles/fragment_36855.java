public class Worker extends Thread {

    private volatile boolean running;

    public void run() {
        running = true;
        while(running) {
            running = doWork();
            if (Thread.interrupted()) {
                return;
            }
        }
    }

    public void stopRunning() {
        running = false;
    }
}