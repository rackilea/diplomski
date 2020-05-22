import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RendezVous extends Thread {

   private final CyclicBarrier _barrier;

   RendezVous( String name, CyclicBarrier barrier ) {
      super( name );

      _barrier = barrier;
      setDaemon( true );
      start();
   }

   @Override public void run() {
      System.out.println( getName() + " waits for counterparts..." );
      try { _barrier.await(); }
      catch( InterruptedException | BrokenBarrierException x ) {
         x.printStackTrace(); }
      System.out.println( getName() + " has reached its rendez-vous!");
   }

   public static void main( String[] args ) throws InterruptedException {
      CyclicBarrier barrier = new CyclicBarrier( 4 );
      new RendezVous( "Rdvz 1", barrier ); Thread.sleep(  1000L );
      new RendezVous( "Rdvz 2", barrier ); Thread.sleep(  1000L );
      new RendezVous( "Rdvz 3", barrier ); Thread.sleep(  1000L );
      new RendezVous( "Rdvz 4", barrier ); Thread.sleep( 10000L );
   }
}