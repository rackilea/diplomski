@Component
public class MyExecutorService {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void add(ConvertTask task) throws InterruptedException {
        Future<String> statusFuture = executorService.submit(task);
    }
}