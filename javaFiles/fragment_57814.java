// Inside onCreate(), set a listener on your Button myButton
Mediaplayer mp = MediaPlayer.create(this, R.raw.yourfile);
myButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
      if (!mp.isPlaying()) {
         // Not playing music
         // START RANDOM MUSIC with mp.start()
         mp.start()
      }
      else {
         // Playing music
         // STOP CURRENT PLAYED MUSIC with mp.stop()
         mp.stop()
      }      
    }
  });