public class BlockUntilAvailableSlot implements RejectedExecutionHandler {
  public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
     if (e.isTerminated() || e.isShutdown()) {
        return;
     }

     boolean submitted = false;
     while (! submitted) {
       if (Thread.currentThread().isInterrupted()) {
            // be a good citizen and do something nice if we were interrupted
            // anywhere other than during the sleep method.
       }

       try {
          e.execute(r);
          submitted = true;
       }
       catch (RejectedExceptionException e) {
         try {
           // Sleep for a little bit, and try again.
           Thread.sleep(100L);
         }
         catch (InterruptedException e) {
           ; // do you care if someone called Thread.interrupt?
           // if so, do something nice here, and maybe just silently return.
         }
       }
     }
  }
}