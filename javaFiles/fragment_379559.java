public class T2 extends Thread {
     private static int count=0;

     private static synchronized void update( ) {
         int v = count;
         try {
             sleep(10);
         } catch (Exception e) { }
         v++;
         count = v;
     }

     @Override
     public void run( ) {
       for (int i = 0; i < 1000; i++) {
       update( );
     }
     }
}