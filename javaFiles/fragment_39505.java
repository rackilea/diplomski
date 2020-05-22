new Handler().postDelayed(new Runnable() {

    @Override
    public void run() {
        Intent startLandingPageActivity = new Intent(MainLauncher.this, LandingPageActivity.class);
        startActivity(startLandingPageActivity);

    }
}, 5000);