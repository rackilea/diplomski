// use a more readable variable name instead of computer_player
final CountDownTimer cdtPlayer = new CountDownTimer(5000, 1000) {
   @Override
   public void onTick(long millisUntilFinished) {
     // do something
   }

   @Override
   public void onFinish() {
     // do something

     // restart to do all again
     cdtPlayer.start();
   }
};

cdtPlayer.start();