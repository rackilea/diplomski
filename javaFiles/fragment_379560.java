public class T2 extends Thread {
     private static final AtomicInteger count = new AtomicInteger();

     @Override
     public void run( ) {
       for (int i = 0; i < 1000; i++) {
         count.incrementAndGet();
       }
     }
}