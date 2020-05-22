final BlockingQueue<Path> queue = new LinkedBlockingDeque<>();
final ExecutorService executorService = Executors.newCachedThreadPool();
final Collection<Future<?>> consumerHandles = new LinkedList<>();
for (int i = 0; i < numConsumers; ++i) {
    consumerHandles.add(executorService.submit(new Consumer(queue)));
}
final Future<?> producerHandle = executorService.submit(new Producer(queue));