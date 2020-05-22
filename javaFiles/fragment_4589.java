private static class Locker implements Runnable {
    private final Object lock;
    private final String message;

    private Locker(final Object lock, final String message) {
        this.lock = lock;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(message);
                    Thread.sleep(1000);
                }
            }
        }
        catch (InterruptedException ex) {

        }
    }
}

public static void main(String[] args) {
    final int numThreads = 2;
    final Object lock = new Object();
    for (int i=0;i<numThreads;i++) {
        new Thread(new Locker(lock, "Hello - " + i)).start();
    }
}