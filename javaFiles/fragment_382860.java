if(mPlayer!=null){
   mPlayer.stop();
   mPlayer.release();}
int id = getResources().getIdentifier(url.substring(26), "raw", getPackageName());;
mPlayer = MediaPlayer.create(getApplicationContext(), id);
mPlayer.start();