public class SplashActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{

   SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
   boolean isGameOver = settings.getBoolean("isGameOver", false);
               if(isGameOver) {
                Intent intent = new Intent(SplashActivity.this,GameOverActivity.class);
                startActivity(intent);
 } else {
        // Start Main Activity
    }
            }
           }
        }; timerThread.start();
}

@Override
protected void onPause() {
    super.onPause();
    finish();
}
}