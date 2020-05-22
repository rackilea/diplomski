public void onClick(View v) {
 int resId;
 switch (v.getId()) {
 case R.id.button_1:
   startMediaPlayer(R.raw.a);
   break;
 case R.id.button_2:
   startMediaPlayer(R.raw.b);
   break;
 case R.id.button_stop:
   mp.stop();
   break;
 default:
   startMediaPlayer(R.raw.a);
   break;
 }

}

public void startMediaPlayer(int resId){
  // Release any resources from previous MediaPlayer
 if (mp != null) {
    mp.release();
 }
 // Create a new MediaPlayer to play this sound
 mp = MediaPlayer.create(getActivity(), resId);
 mp.setLooping(true);
 mp.start();
}