@Component
public class YourCronJobExecutor {

    private int threadsNumber = 10;
    private ExecutorService executorService;

    @PostConstruct
    private void init() {
        executorService = Executors.newFixedThreadPool(threadsNumber);
    }

    /**
     * Start.
     * @param runnable - runnable instance.
     */
    public void start(Runnable runnable) {
        try {
            executorService.execute(runnable);
        } catch (RejectedExecutionException e) {
            init();
            executorService.execute(runnable);
        }
    }
}