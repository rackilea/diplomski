CountDownTimer timer;
int timeStampIterator;
int[] timeStamp = new int[5]; // your own time stamps when view must be switched

void play() { 
   mPlayer.start();
    timer = new CountDownTimer(mPlayer.getDuration() - mPlayer.getCurrentPosition(), 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            int timeSpends = mPlayer.getDuration() - mPlayer.getCurrentPosition();
            if (timeSpends == timeStamp[timeStampIterator]) {
                //switchToNExtSlide();
                timeStampIterator++;
            }
        }

        @Override
        public void onFinish() {

        }
    }.start();
}

void pause() {
    mPlayer.pause();
    timer.cancel();
    timer = null;
}

void stop() {
    mPlayer.stop();
    timer.cancel();
    timer = null;
    timeStampIterator = 0;
}