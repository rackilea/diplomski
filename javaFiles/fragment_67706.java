class ClientThread implements Runnable {
   private final CountDownLatch doneSignal;
   ClientThread (CountDownLatch doneSignal) {
      this.doneSignal = doneSignal;
   }
   public void run() {
      try {
        //Do something
        doneSignal.countDown();
      } catch (InterruptedException ex) {} 
   }
 }
...
//In main thread
doneSignal.await();