Runnable myRunnable = new Runnable() {
    @Override
    public void run() {
        finish();
    }
};

public static Handler myHandler = new Handler();
private static final int TIME_TO_WAIT = 5000;

@Override
public void onUserInteraction() {
    restart();
}

public void start() {
    myHandler.postDelayed(myRunnable, TIME_TO_WAIT);
}

public void stop() {
    myHandler.removeCallbacks(myRunnable);
}

public void restart() {
    myHandler.removeCallbacks(myRunnable);
    myHandler.postDelayed(myRunnable, TIME_TO_WAIT);
}