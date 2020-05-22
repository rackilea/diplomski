this.countDown = new PreciseCountdown(totalTime, interval, delay) {
    @Override
    public void onTick(long timeLeft) {
        // update..
        // note that this runs on a different thread, so to update any GUI components you need to use Activity.runOnUiThread()
    }

    @Override
    public void onFinished() {
        onTick(0); // when the timer finishes onTick isn't called
        // count down is finished
    }
};