final Intent intent;
if (ads.enable()) {
    intent = new Intent(SplashScreen.this, WelcomeActivity.class);
    prefManager.setFirstTimeLaunch(false);
} else if (bn_bstatus.equals("enable")) {
    intent = new Intent(SplashScreen.this, Ads_Fullscreen.class);
    SPLASH_TIME_OUT = 2000;
} else {
    intent = new Intent(SplashScreen.this, MainActivity.class);
}
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        startActivity(intent);
        finish();
    }
}, SPLASH_TIME_OUT);