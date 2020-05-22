clock.post(new Runnable() {
    @Override public void run() {
        clock.setText(convertTime());
        // 50 millis to give the ui thread time to breath. Adjust according to your own experience
        clock.postDelayed(this, 50);
    }
});