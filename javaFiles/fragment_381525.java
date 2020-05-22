private final Runnable timerRunnable = new Runnable() {
    @Override
    public void run() {
        int x = theSprite.getScrollX();
        int y = theSprite.getScrollY();
        y-=5;
        theSprite.scrollTo(x, y);
        if (!closing)
            startTimer();
    }
};

handler = new Handler();
startTimer();

/**
 * Start periodically callbacks.
 */
private void startTimer() {
    runOnUiThreadDelay(timerRunnable, 400L);
}

public void runOnUiThreadDelay(final Runnable runnable, long delayMillis) {
    handler.postDelayed(runnable, delayMillis);
}