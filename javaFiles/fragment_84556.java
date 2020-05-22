new Handler().postDelayed(new Runnable(){
    @Override
    public void run() {
        Intent homeIntent=new Intent(SplashScreen.class,MainActivity.this);
        startActivity(homeIntent);
        finish();
    }
}, SPLASH_TIME_OUT); // See the comma?