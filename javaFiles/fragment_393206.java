try {
   executorService.execute(new Runnable() { ... });
}
catch (RejectedExecutionException e) {
   // the queue is full, and you're using the AbortPolicy as the 
   // RejectedExecutionHandler
}