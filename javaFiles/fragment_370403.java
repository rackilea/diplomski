mp = new MediaPlayer();
if (playSounds) {
    mp.setVolume(1, 1);
} else {
    mp.setVolume(0, 0);
}

AssetFileDescriptor afd;
...
mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer unused) {
        mp.release();
        mp = null;
    }
});
mp.start();