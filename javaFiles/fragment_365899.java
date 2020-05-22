int fixedThreadNumber = 10;
int idleSeconds = 10;

BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(10);

ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
        fixedThreadNumber,
        fixedThreadNumber,
        idleSeconds, TimeUnit.SECONDS, 
        blockingQueue, new ThreadPoolExecutor.DiscardOldestPolicy());

ExecutorService executor = threadPoolExecutor;