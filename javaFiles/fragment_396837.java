// You can easily create a service which runs tasks over many threads
ExecutorService service = Executors.newCachedThreadPool(); 
// Just put your task to run
service.submit( /* Runnable or Callable */ );
// Shutdown the service after (it will wait for current tasks terminaison)
service.shutdown();