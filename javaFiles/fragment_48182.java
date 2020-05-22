protected void onCreate(Bundle splashBundle) 
        {
            super.onCreate(splashBundle);
            setContentView(R.layout.splash);

            splashSound = MediaPlayer.create(SplashActivity.this, 
                                                R.raw.droid);   
            splashSound.setOnCompletionListener(new 
                              MediaPlayer.OnCompletionListener() {
           @Override
            public void onCompletion(MediaPlayer splashSound) {

             splashSound.stop();
             splashSound.release();
                   //start your Next Activity here
           }
        });
        splashSound.start();  //<<<play sound on Splash Screen
   }