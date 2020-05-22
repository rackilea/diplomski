// Implement class Runner

public class Runner implements Runnable {
    private String mLine;

    public Runner(String line) {
        mLine = line;
    }

    @Override
    public void run() {
        process();
    }

    public void process() {
        // Do processing with mLine
        // Put synchronized if you need, it bases on your context
    }
}

// Initialize thread pool

private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

// Execute runner when receiving callback

onClick(String s) {
        Runner runner = new Runner(s);
        executor.execute(runner);
    }