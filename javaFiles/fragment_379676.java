import java.util.concurrent.atomic.AtomicInteger;

class FixedStateWorker implements Runnable {
    private AtomicInteger val = new AtomicInteger();
    //      ↑↑↑↑↑↑↑↑↑↑↑↑↑       ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            val.getAndIncrement();
            //  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
            Thread.yield();
            val.getAndIncrement();
            //  ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
        }
        showDataState();
    }
}