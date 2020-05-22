ExecutorService executorService = Executors.newFixedThreadPool(10);
... assign/invoke tasks etc

... at some point later your program is told to shutdown 
... shutdown in executor too 
executorService.shutdown();
executorService.awaitTermination(10, TimeUnit.SECONDS); // wait for 10s in this case
executorService.shutdownNow();