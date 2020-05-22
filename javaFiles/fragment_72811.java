class Test
 {

   static CountDownLatch latch = new CountDownLatch(1);

   public static void t1()
   {
           //This method will be called in a Thread called T2
           /*This method must wait for flag to become 1. As soon it
             becomes 1 this must return. However it should wait for maximum 
             n seconds. After that even if flag is 0 it must return.*/
           latch.await(1L,TimeUnit.SECONDS);
           //your remaining logic
   }



   public static void m1()
   {
          //your logic
          latch.countDown();
   }
}