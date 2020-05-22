int SPLASH_TIME_OUT = 3000;
new Handler().postDelayed(new Runnable() {

    /*
     * Showing splash screen with a timer. This will be useful when you
     * want to show case your app logo / company
     */

    @Override
    public void run() {
        // This method will be executed once the timer is over
        // Start your app main activity
        Intent i = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        // close this activity
        finish();
    }
}, SPLASH_TIME_OUT);