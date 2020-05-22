public class AutoShutdown<V> implements Callable<V> {

    private final ExecutorService executorService;
    private final Callable<V> task;

    public AutoShutdown(final ExecutorService executorService, final Callable<V> task) {
        this.executorService = executorService;
        this.task = task;
    }

    @Override
    public V call() throws Exception {
        try {
            return task.call();
        } catch (CustomException e) {
            executorService.shutdownNow();
            throw e;
        }
    }
}