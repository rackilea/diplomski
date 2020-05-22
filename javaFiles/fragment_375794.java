public class Stopwatch extends Thread {
    //...
    private final Object pauseLock;

    public Stopwatch() {
        pauseLock = new Object();
    }

    public Stopwatch(boolean finished, boolean pause, boolean sort, JLabel timer) {
        this();
        //...
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (sortFlag && !finishedFlag) {
            while (pauseFlag) {
                synchronized (pauseLock) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException ex) {
                    }
                }
            }
            update(summedTime + (System.currentTimeMillis() - startTime));
        }
        if (pauseFlag) {
            summedTime += System.currentTimeMillis() - startTime;
        } else {
            summedTime = 0;
        }
    }