public class CatchAllRunnable implements Runnable{
     private final Runnable wrappee;

     public CatchAllRunnable( Runnable r ){ wrappee = r; }

     @Override
     public void run(){
         try{ wrappee.run(); }
         catch( Exception e ){ /* LOG e */ }
     }
}