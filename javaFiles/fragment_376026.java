mp1 = MediaPlayer.create(sound.this, R.raw.pan1);
mp1.start();
    mp1.setOnCompletionListener(new OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
        mp.release();

        };
    });