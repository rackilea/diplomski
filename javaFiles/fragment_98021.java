public class PrintOneTwoThree {
    private static int currentTask;
    private static int totalThreads;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        currentTask = 0;
        totalThreads = 3;

        for (int i = 0; i < totalThreads; i++) {
            createThread(i);
        }
    }

    static void createThread(int id) {
        new Thread(() -> {
            try {
                for (;;) {
                    synchronized (lock) {
                        while (currentTask != id) {
                            lock.wait();
                        }

                        System.out.print(id + 1 + " ");
                        currentTask = (currentTask + 1) % totalThreads;
                        lock.notifyAll();
                    }
                }
            }
            catch (InterruptedException ignored) {}
        }).start();
    }
}