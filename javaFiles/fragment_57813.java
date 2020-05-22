// Delcare a boolean as an attribute to be accessible inside the listener
private boolean isPlaying = false;

// Inside onCreate(), set a listener on your Button myButton
Mediaplayer mp = MediaPlayer.create(this, R.raw.yourfile);
myButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
      if (!isPlaying) {
         // Not playing music
         // START RANDOM MUSIC with mp.start()
         mp.start()
         isPlaying = true;
      }
      else {
         // Playing music
         // STOP CURRENT PLAYED MUSIC with mp.stop()
         mp.stop()
         isPlaying = false;
      }      
    }
  });