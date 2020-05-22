public void stop() {
    if (mp != null) {
        mp.release();
        mp = null;
    }
}

public void play(int rid) {
    stop();

    mp = MediaPlayer.create(this, rid);
    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            stop();
        }
    });

    mp.start();
}