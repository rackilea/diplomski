public void run() {
   // only quit the loop if the thread is interrupted
   while (!Thread.currentThread().isInterrupted()) {
      try {
         // do some stuff that might throw
         repeat task;
      } catch (Exception e) {
         // recover from the throw here but then continue running
      }
   }
}