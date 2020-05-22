ExecutorService executorService = Executors.newFixedThreadPool(2000);
ArrayList<Future> futures = new ArrayList<>();

futures.add(executorService.submit(new MyTask()));
futures.add(executorService.submit(new MyTask()));
futures.add(executorService.submit(new MyTask()));

for (Future future: futures) {
    try {
        future.get(100, TimeUnit.SECONDS); 
    } catch (Throwable cause) {
        // process cause
    }
}