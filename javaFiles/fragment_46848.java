public class YourResource {
   private static final int MAX_CONCURRENT_THREADS = 4;

   private Semaphore semaphore = new Semaphore(MAX_CONCURRENT_THREADS ); 

   public void doSomethingWithYourResource() {
      semaphore.acquire();
      try {
         // Code accessed by 4 concurrent threads, tops
      } finally {
         semaphore.release();
      }
   }
}