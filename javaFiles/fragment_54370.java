// declare mp as class field.
MediaPlayer mp = null;

//...

case R.id.playButton:
    if (mp != null)
        mp.release();
    switch (korean.getIndex()){
    case -1: break; // This is the case when the program first starts.
    case 0: mp = MediaPlayer.create(this, R.raw.c0);mp.start(); break; 
    case 1: mp = MediaPlayer.create(this, R.raw.c1);mp.start(); break; 
    case 2: mp = MediaPlayer.create(this, R.raw.c2);mp.start(); break; 
    // and so on