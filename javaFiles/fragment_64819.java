import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class CocnurrentHashMap2Benchmark {
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
            testComputeIfAbsent2Lambda();
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


     private static void testComputeIfAbsent2Lambda() throws InterruptedException {
            final AtomicLong totalTime = new AtomicLong();
            final ConcurrentHashMap2<String, AtomicInteger> map = new ConcurrentHashMap2<String, AtomicInteger>();
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

                            AtomicInteger count = map.computeIfAbsent2(s, (k) -> new AtomicInteger(0));
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

        public static class ConcurrentHashMap2<K,V> extends ConcurrentHashMap<K,V> {

            /**
             * If there is no mapping for the key then computes and puts the mapping,
             * otherwise it simply return the value for that key.
             * In case of concurrent initialization of the same key the mappingFunction can be called more than once.
             * @param key - the key to be initialized or retrieved
             * @param mappingFunction - the function to be called for computation of initial value.
             * @return computed value if the key wasn't already in the map otherwise return the actual value for provided key.
             */
            public V computeIfAbsent2(K key, Function<K,V> mappingFunction) {
                V value = get(key);
                if (value == null) {
                    value = mappingFunction.apply(key);
                    V prevValue = putIfAbsent(key, value);
                    if (prevValue != null) {
                        value = prevValue;
                    }
                }
                return value;
            }
        }
}