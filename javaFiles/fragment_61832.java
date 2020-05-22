public class MyView extends SurfaceView implements SurfaceHolder.Callback {

     // your other fields
     private GameListener mGameListener;

     public void setGameListener(GameListener gameListener) {
         mGameListener = gameListener;
     }

     public void update() {
         // your logic
         if (mGameListener != null) {
             // calling onGameEnd on the main thread
             post(new Runnable() {

                 public void run() {
                     mGameListener.onGameEnd();
                 }

             });
         }
     }

     // rest of your class as it is

     public interface GameListener {

         void onGameEnded();

     }
}

public class MainActivity extends Activity implements GameListener {

    // the rest of your class

    public void onGameEnded() {
        // call the method you need
    } 
}