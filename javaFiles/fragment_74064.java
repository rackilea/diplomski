import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo extends Thread {

   private final CountDownLatch _cdl;

   CountDownLatchDemo( String name, CountDownLatch cdl ) {
      super( name );

      _cdl = cdl;
      setDaemon( true );
      start();
   }

   @Override public void run() {
      System.out.println( getName() + " waits for counterparts..." );
      try {
         _cdl.countDown();
         _cdl.await();
      }
      catch( InterruptedException x ) {
         x.printStackTrace(); }
      System.out.println( getName() + " has reached its rendez-vous!");
   }

   public static void main( String[] args ) throws InterruptedException {
      CountDownLatch cdl = new CountDownLatch( 4 );
      new CountDownLatchDemo( "Rdvz 1", cdl ); Thread.sleep(  1000L );
      new CountDownLatchDemo( "Rdvz 2", cdl ); Thread.sleep(  1000L );
      new CountDownLatchDemo( "Rdvz 3", cdl ); Thread.sleep(  1000L );
      new CountDownLatchDemo( "Rdvz 4", cdl ); Thread.sleep( 10000L );
   }
}