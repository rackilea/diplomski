ExecutorService executor = Executors.newCachedThreadPool();
Callable<Object> task = new Callable<Object>() {
   public Object call() {
      return something.blockingMethod();
   }
};
Future<Object> future = executor.submit(task);
try {
   Object result = future.get(5, TimeUnit.SECONDS); 
} catch (TimeoutException ex) {
   // handle the timeout
} catch (InterruptedException e) {
   // handle the interrupts
} catch (ExecutionException e) {
   // handle other exceptions
} finally {
   future.cancel(true); // may or may not desire this
}