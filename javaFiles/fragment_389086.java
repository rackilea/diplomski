public class SelectPairs {

    private static final int NUM_THREADS = 8;

    private int[] array;

    public SelectPairs(int[] arr) {
        array = arr;
    }

    // A splitting task strategy
    public List<Pair> getPartialPairs(int threadIndex, int numThreads) {
        List<Pair> pairs = new ArrayList<Pair>();
        int total = array.length;
        for (int i = threadIndex; i < total; i += numThreads) {
            int num1 = array[i];
            for (int j = i + 1; j < total; j++) {
                int num2 = array[j];
                pairs.add(new Pair(num1, num2));
            }
        }
        return pairs;
    }

    // To use Callables or Runnables are better than extends a Thread.
    public static class PartialPairsCall implements Callable<List<Pair>> {

        private int thread;
        private int totalThreads;
        private SelectPairs selectPairs;

        public PartialPairsCall(int thread, int totalThreads, SelectPairs selectPairs) {
            this.thread = thread;
            this.totalThreads = totalThreads;
            this.selectPairs = selectPairs;
        }

        @Override
        public List<Pair> call() throws Exception {
            return selectPairs.getPartialPairs(thread, totalThreads);
        }
    }


    public static void main(String[] args) throws Exception {

        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        SelectPairs sp = new SelectPairs(a);

        // Create a thread pool 
        ExecutorService es = Executors.newFixedThreadPool(NUM_THREADS);
        List<Future<List<Pair>>> futures = new ArrayList<>(NUM_THREADS);

        // Submit task to every thread:
        for (int i = 0; i < NUM_THREADS; i++) {
            futures.add(es.submit(new PartialPairsCall(i, NUM_THREADS, sp)));
        }

        // Collect the results:
        List<Pair> result = new ArrayList<>(a.length * (a.length - 1));
        for (Future<List<Pair>> future : futures) {
            result.addAll(future.get());
        }

        // Shutdown thread pool
        es.shutdown();

        System.out.println("result: " + result.size());
    }
}