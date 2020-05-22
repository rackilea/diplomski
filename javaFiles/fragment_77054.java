public void stopMediaPlayer() {
    if (mediaPlayer != null) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        mediaPlayer = null;
    }
}

    stopper.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adapter.stopMediaPlayer();
        }
    });