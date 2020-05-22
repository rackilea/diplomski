ExecutorService service = Executors.newFixedThreadPool(N);
ScheduledExecutorService canceller = Executors.newSingleThreadScheduledExecutor();

public <T> Future<T> executeTask(Callable<T> c, long timeoutMS){
   final Future<T> future = service.submit(c);
   canceller.schedule(new Callable<Void>(){
       public Void call(){
          future.cancel(true);
          return null;
       }
    }, timeoutMS, TimeUnit.MILLI_SECONDS);
   return future;
}