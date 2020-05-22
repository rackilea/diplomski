final CountDownLatch countdown = new CountDownLatch(1);
for (int i = 0; i < 10; ++ i){
   Thread racecar = new Thread() {    
      public void run()    {
         countdown.await(); //all threads waiting
         System.out.println("Vroom!");
      }
   };
   racecar.start();
}
System.out.println("Go");
countdown.countDown();   //all threads start now!