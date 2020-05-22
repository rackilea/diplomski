public class AndroidLauncher extends AndroidApplication implements Service {

   View gameView;

   @Override
   protected void onCreate (Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       gameView=initializeForView(new Main(this), config);
       setContentView(gameView);
   }

   @Override
   public void keepScreenOn(final boolean isOn) {

       runOnUiThread(new Runnable() { 
            @Override 
            public void run() { 
                gameView.setKeepScreenOn(isOn); 
            } 
       });
   }
 }