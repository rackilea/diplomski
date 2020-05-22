MediaPlayer mPlayer;
mPlayer=adapter.getMPlayerInstace();
if(mPlayer!=null){
    mPlayer.stop();
    mPlayer.release();
}