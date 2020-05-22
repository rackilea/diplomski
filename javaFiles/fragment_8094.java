mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
  public void onPrepared(MediaPlayer mp) {
      mp.start();
  }
});
mediaPlayer.prepareAsync();