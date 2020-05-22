Handler handler;
protected void onCreate(Bundle splashBundle) 
    {
        super.onCreate(splashBundle);
        setContentView(R.layout.splash);
        handler = new Handler();  
        splashSound = MediaPlayer.create(SplashActivity.this, 
                                            R.raw.droid);   
        splashSound.start();  //<<<play sound on Splash Screen
        handler.postDelayed(runnable, 5000);
    }
private Runnable runnable = new Runnable() {
   @Override
   public void run() {
     //start your Next Activity here
   }
};