//Closes activity after 10 seconds of inactivity
public void onUserInteraction(){
    myHandler.removeCallbacks(closeControls);
    myHandler.postDelayed(closeControls, delayTime);
}

private Runnable closeControls = new Runnable() {
    public void run() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
};