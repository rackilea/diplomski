public class MyRunnable implements Runnable {

   private boolean result;

   public MyRunnable( ) {
      this.result = false;
   }

   @Override
   public void run( ) {
      this.result = true;
      this.notifyAll();
   }

   public boolean getResult( ) {
      return this.result;
   }

}