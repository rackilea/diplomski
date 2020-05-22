final CountDownLatch countdown = new CountDownLatch(num_thread);
for (int i = 0; i < num_thread; ++ i){
   Thread t= new Thread() {    
      public void run()    {
         doSomething();
         countdown.countDown();
         System.out.printf("Waiting on %d other threads.",countdown.getCount());
         countdown.await();     //waits until everyone reaches this point
         finish();
      }
   };
   t.start();
}