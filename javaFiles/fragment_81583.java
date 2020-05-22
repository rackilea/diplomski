int NUMBER_OF_SOUNDS = 3; // Number of Sounds
MediaPlayer[] playword = new MediaPlayer[NUMBER_OF_SOUNDS];
 for(int i=0;i < NUMBER_OF_SOUNDS; i++){
     playword[i] = MediaPlayer.create(this, getResources().getIdentifier("word" + Integer.toString(i), "raw", getPackageName()));
     playword[i].setAudioStreamType(AudioManager.STREAM_MUSIC);
 }