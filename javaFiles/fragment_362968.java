mediaPlayer.setOnEndOfMedia(new Runnable() {
    @Override
    public void run() {
        mediaPlayer.stop();
    }
});