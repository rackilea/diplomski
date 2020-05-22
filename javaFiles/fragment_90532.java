private boolean pending = false;
private Handler handler = new Handler();
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
        //Remove listener
        pending = false;
    }
};

@Override
protected void onStart() {
    super.onStart();
    if (pending) {
        handler.removeCallbacks(runnable);
    } else {
        //Attach listener
    }
    pending = false;
}

@Override
protected void onStop() {
    super.onStop();
    handler.postDelayed(runnable, 3000);
    pending = true;
}