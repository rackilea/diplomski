int poolSize = 3;
ExecutorService executorService =  new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

for (String arg : args) {
    executorService.submit(() -> {
        service.parse(arg).forEach(System.out::println);
    });
}