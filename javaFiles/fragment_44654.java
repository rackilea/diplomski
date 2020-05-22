myMediaPlayer.setOnCompletionListener(this);

 public void onCompletion(MediaPlayer arg0) {
      arg0.release();
      if (counter < songs.size()) {
        counter++;
        arg0 = MediaPlayer.create(getApplicationContext(), songs.get(counter);
        arg0.setOnCompletionListener(this);
        arg0.start();
      }
    }