public void onPrepared(MediaPlayer mediaPlayer) {
    Log.d(TAG, "onPrepared");
    mediaController.setMediaPlayer(this);

    handler.post(new Runnable() {
      public void run() {
        mediaController.setEnabled(true);
        mediaController.show();
      }
    });
  }