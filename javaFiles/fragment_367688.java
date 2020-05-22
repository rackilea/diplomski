// Will call onFinish() after 2 seconds. Second parameter is 
// for onTick() which we don't need and can ignore.
new CountDownTimer(2000, 2000) {

     public void onTick(long millisUntilFinished) {
         // Do nothing...
     }

     public void onFinish() {
         mediaPlayer.stop();  
         // Decide here if you need to prepare a new clip
         // or release the media player
     }

}.start();