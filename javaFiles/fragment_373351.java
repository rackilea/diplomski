public class ThreadVisibility implements Runnable {

    private boolean stop = false;

    @Override
    public void run() {
        while (!stop);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadVisibility test = new ThreadVisibility();
        Thread t = new Thread(test);
        t.setDaemon(true);
        System.out.println("Starting Thread");
        t.start();
        Thread.sleep(1000);
        System.out.println("Stopping Thread");
        test.stop = true;
        t.join(1000);
        System.out.println("Thread State: " + t.getState());
    }
}