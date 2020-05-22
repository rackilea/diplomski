public class UnsafeResponder implements Runnable {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int LIMIT = 1000000; // More operations
    private int THREADS = 10;    // More threads

    public void run()
        // Less delays
        for(int i = 0; i < LIMIT; i++){
            list.add(i);
        }
    }

    public void execute(){
        List<Thread> threads = new ArrayList<Thread>();
        for (int t = 0; t < THREADS; t++) {
            Thread th = new Thread(this);
            th.start();
            threads.add(th);
        }

        try {
            for (Thread th : threads) {
                th.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Test failed!", e);
        }

        System.out.println("Expected: " + (THREADS * LIMIT));
        System.out.println("  Actual: " + list.size());
    }
}