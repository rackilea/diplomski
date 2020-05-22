public class SomeService {

   private final ReentrantLock lock = new ReentrantLock(); // or store it in context based on your needs
   // ...

   /** this method refuse to process if there is already ongoing processing */
   public void heavyProcessing() {

     synchronized (lock) {
       if (lock.isLocked()) {
          // return busy status here
          return;     
       }

       lock.lock();  // acquire the lock - here we have the winner request that will be processed
     }
     try {
       // ... do the processing here
     } finally {
       lock.unlock()
     }
   }
 }