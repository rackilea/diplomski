if(play)
    {
      //paused
      play =false;
      pause.setImageResource(R.id.pause);
      length=mediaPlayer.getCurrentPosition(); 
      mediaPlayer.pause();
    }else { 
      //resumed
      play = true;
      pause.setImageResource(R.id.resume);
       mediaplayer.seekTo(length);
            mediaPlayer.start();
    }