protected void onDestroy(){
  super.onDestroy();
}
public void onPause(){
  super.onPause();
  gv.gameLoopThread.setRunning(false);

}
public void redirectHome(){
 Intent intent=new Intent(PlayActivity.this, MainActivity.class);
 startActivity(intent);
 finish();
}