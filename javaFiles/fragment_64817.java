import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHashMapTest {
    private final static int numberOfRuns = 1000000;
    private final static int numberOfThreads = Runtime.getRuntime().availableProcessors();
    private final static int keysSize = 10;
    private final static String[] strings = new String[keysSize];
    static {
        for (int n = 0; n < keysSize; n++) {
            strings[n] = "" + (char) ('A' + n);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 20; n++) {
            testPutIfAbsent();
            testComputeIfAbsentLambda();
        }
    }

    private static void testPutIfAbsent() throws InterruptedException {
        final AtomicLong totalTime = new AtomicLong();
        final ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();
        final Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long start, end;
                    for (int n = 0; n < numberOfRuns; n++) {
                        String s = strings[random.nextInt(strings.length)];
                        start = System.nanoTime();

                        AtomicInteger count = map.get(s);
                        if (count == null) {
                            count = new AtomicInteger(0);
                            AtomicInteger prevCount = map.putIfAbsent(s, count);
                            if (prevCount != null) {
                                count = prevCount;
                            }
                        }
                        count.incrementAndGet();
                        end = System.nanoTime();
                        totalTime.addAndGet(end - start);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("Test " + Thread.currentThread().getStackTrace()[1].getMethodName()
                + " average time per run: " + (double) totalTime.get() / numberOfThreads / numberOfRuns + " ns");
    }

    private static void testComputeIfAbsentLambda() throws InterruptedException {
        final AtomicLong totalTime = new AtomicLong();
        final ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<String, AtomicInteger>();
        final Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long start, end;
                    for (int n = 0; n < numberOfRuns; n++) {
                        String s = strings[random.nextInt(strings.length)];
                        start = System.nanoTime();

                        AtomicInteger count = map.computeIfAbsent(s, (k) -> new AtomicInteger(0));
                        count.incrementAndGet();

                        end = System.nanoTime();
                        totalTime.addAndGet(end - start);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("Test " + Thread.currentThread().getStackTrace()[1].getMethodName()
                + " average time per run: " + (double) totalTime.get() / numberOfThreads / numberOfRuns + " ns");
    }

}