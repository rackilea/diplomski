import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class CachedObject {

    private static final AtomicInteger createCount = new AtomicInteger();
    static final long createTimeMs = 100L;

    private final int instanceNumber = createCount.incrementAndGet();

    public CachedObject() {
        println("Creating cached object " + instanceNumber);
        try {
            Thread.sleep(createTimeMs);
        } catch (Exception ignored) {}
        println("Cached object " + instanceNumber + " created");
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "-" + getInstanceNumber();
    }

    private static final long startTime = System.currentTimeMillis();

    /**
     * Test the use of DbCachedObject.
     */
    public static void main(String[] args) {

        ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        final int tcount = 2; // amount of tasks running in paralllel
        final long threadStartGracePeriodMs = 50L; // starting runnables takes time
        try {
            // verify first calls wait for initialization of first cached object
            fetchCacheTasks(tp, tcount, createTimeMs + threadStartGracePeriodMs);
            // verify immediate return of cached object
            CachedObject o = DbCachedObject.INSTANCE.get();
            println("Cached: " + o);

            // wait for refresh-period
            Thread.sleep(DbCachedObject.INSTANCE.getCachePeriodMs() + 1);
            // trigger update
            o = DbCachedObject.INSTANCE.get();
            println("Triggered update for " + o);
            // wait for update to complete
            Thread.sleep(createTimeMs + 1);
            // verify updated cached object is returned
            fetchCacheTasks(tp, tcount, threadStartGracePeriodMs);

            // trigger update
            DbCachedObject.INSTANCE.refresh();
            // wait for update to complete
            Thread.sleep(createTimeMs + 1);
            println("Refreshed: " + DbCachedObject.INSTANCE.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tp.shutdownNow();
        }
    }

    private static void fetchCacheTasks(ThreadPoolExecutor tp, int tasks, long doneWaitTimeMs) throws Exception {

        final CountDownLatch fetchStart = new CountDownLatch(tasks);
        final CountDownLatch fetchDone = new CountDownLatch(tasks);
        // println("Starting " + tasks + " tasks");
        for (int i = 0; i < tasks; i++) {
            final int r = i;
            tp.execute(new Runnable() {
                @Override public void run() {
                    fetchStart.countDown();
                    try { fetchStart.await();} catch (Exception ignored) {}
                    CachedObject o = DbCachedObject.INSTANCE.get();
                    println("Task " + r + " got " + o);
                    fetchDone.countDown();
                }
            });
        }
        println("Awaiting " + tasks + " tasks");
        if (!fetchDone.await(doneWaitTimeMs, TimeUnit.MILLISECONDS)) {
            throw new RuntimeException("Fetch cached object tasks incomplete.");
        }
    }

    private static void println(String msg) {
        System.out.println((System.currentTimeMillis() - startTime) + " "  + msg);
    }
}