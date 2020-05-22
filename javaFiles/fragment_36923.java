@Service
public class DocumentService {

    private final ExecutorService executor;

    @Autowired
    public DocumentService(
        @Value("${some.config.property}") int maxConcurrentThreads) {
        // will allow only the given number of threads
        executor = Executors.newFixedThreadPool(maxConcurrentThreads);
    }

    private void doReplacementWithLimitedConcurrency(String s, int i){
        Future<?> future = executor.submit(() -> doReplacement(s, i));
        future.get(); // will block until a thread picks up the task
                      // and finishes executing doReplacement
    }

    private void doReplacement(String s, int i){
    }

    // other methods

    @PreDestroy
    public void performThreadPoolCleanup() throws Exception {
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS); 
        executor.shutdownNow();
    }
}