import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class SO {

   static boolean isTrue = true;

   public static void main( String[] args ) {
      new Timer().scheduleAtFixedRate( new TimerTask() {
         @Override public void run() {
            System.out.println(
               System.currentTimeMillis() + ": " + Thread.currentThread());
            try{
               if( isTrue ) {
                  TimeUnit.SECONDS.sleep( 1 );
                  isTrue = false;
               }
            }
            catch( InterruptedException e ){
               e.printStackTrace();
            }
         }
      }, 0, 100 );
   }
}