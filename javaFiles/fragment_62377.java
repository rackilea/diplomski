public class Worker implements Runnable {
   private Queue<String> myQueue = new Queue<String>();
   public void run()
   {
       while (true) {
          string messageToProcess = null;
          synchronized (myQueue) {
             if (!myQueue.empty()) {
                 // get your data from queue
                 messageToProcess = myQueue.pop();
             }
          }
          if (messageToProcess != null) {
             // do your stuff
          }
          Thread.sleep(500); // to avoid spinning
       }
   }
   public void queueMessage(String message)
   {
      synchronized(myQueue) {
         myQueue.add(message);
      }
   }
}