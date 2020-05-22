public class YourPool extends ThreadPoolTaskExecutor {
    @Override
    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        return new PriorityBlockingQueue<>(queueCapacity);
    }
}