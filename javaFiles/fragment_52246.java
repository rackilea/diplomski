// Prevent Media Player taking so long time
    private void postDelayed() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mMediaPlayer.reset();
            }}, 5000);  // 5 seconds

    }