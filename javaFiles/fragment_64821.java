import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class CocnurrentHashMap2PutBenchmark {
    private final static int numberOfRuns = 1000000;
    private final static int numberOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 20; n++) {
            testComputeIfAbsent2();
            testComputeIfAbsent();
        }
    }

    private static void testComputeIfAbsent2() throws InterruptedException {
        final AtomicLong totalTime = new AtomicLong();
        final ConcurrentHashMap2<Integer, String> map = new ConcurrentHashMap2<Integer, String>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long start, end;
                    for (int n = 0; n < numberOfRuns; n++) {
                        Integer key = Integer.valueOf(n);
                        start = System.nanoTime();

                        String value = map.computeIfAbsent2(key, (k) -> "value");

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

    private static void testComputeIfAbsent() throws InterruptedException {
        final AtomicLong totalTime = new AtomicLong();
        final ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long start, end;
                    for (int n = 0; n < numberOfRuns; n++) {
                        Integer key = Integer.valueOf(n);
                        start = System.nanoTime();

                        String value = map.computeIfAbsent(key, (k) -> "value");

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

    public static class ConcurrentHashMap2<K, V> extends ConcurrentHashMap<K, V> {

        /**
         * If there is no mapping for the key then computes and puts the
         * mapping, otherwise it simply return the value for that key. In case
         * of concurrent initialization of the same key the mappingFunction can
         * be called more than once.
         * 
         * @param key
         *            - the key to be initialized or retrieved
         * @param mappingFunction
         *            - the function to be called for computation of initial
         *            value.
         * @return computed value if the key wasn't already in the map otherwise
         *         return the actual value for provided key.
         */
        public V computeIfAbsent2(K key, Function<K, V> mappingFunction) {
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