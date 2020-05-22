MediaPlayer player = MediaPlayer.create(this,  R.raw.zindgivalaaop);
player.setVolume(50,50);
player.start();

@Override
public void onDestroy() {
     super.onDestroy();
     player.stop();
     player.release();
}