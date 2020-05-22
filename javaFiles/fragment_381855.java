import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThreadsExecutor {
    private static final Logger asyncLOGGER = LoggerFactory.getLogger("ASYNC_FILE_LOG");
    private static final Logger normaLOGGER = LoggerFactory.getLogger("FILE_LOG");
    static CountDownLatch latch = null; // Java7 feature to ensure all threads ended execution.

    public MultiThreadsExecutor() {
    }

    public void someMethod(String who, String loggerName) {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                getLogger(loggerName).warn(Thread.currentThread().getName() +": is Running in the background");
                for (int i=0; i<100; i++) {
                    getLogger(loggerName).info(Thread.currentThread().getName() +" counting: " + i);
                }
                latch.countDown();
            }
        },"Background " + who + " Thread");
        backgroundThread.start();
    }

    private Logger getLogger(String name) {
        if (name.equals("ASYNC_FILE_LOG")) {
            return asyncLOGGER;
        } else if (name.equals("FILE_LOG")) {
            return normaLOGGER;
        } else {
            System.out.println("Logger Undefined");
            return null;
        }
    }

    public static void main(String[] args) {
        long start;
        MultiThreadsExecutor mte = new MultiThreadsExecutor();

        latch = new CountDownLatch(10);
        start = System.currentTimeMillis();
        for (int i=0; i<10; i++) {
            mte.someMethod(Integer.toString(i)," FILE_LOG");
        }
        try {
            latch.await();
            System.out.println("FILE_LOG ended - " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch = new CountDownLatch(10);
        start = System.currentTimeMillis();
        for (int i=0; i<10; i++) {
            mte.someMethod(Integer.toString(i)," ASYNC_FILE_LOG");
        }
        try {
            latch.await();
            System.out.println("ASYNC_FILE_LOG ended - " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Remove below to enable Testcase(2)
        // try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("END");
   }
}