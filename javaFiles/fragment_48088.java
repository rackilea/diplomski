public class ThreePointFiveSecondsTimer extends CountDownTimer {

            public ThreePointFiveSecondsTimer(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {

              remainingTime = millisUntilFinished;//set the remaining time
            }

            @Override
            public void onFinish() {

//start the 120 second countdowntimer again
    mHundredTwentySecondsTimer  = new MyCountDownTimer(remainingTime, 1000);
    mHundredTwentySecondsTimer.start();
            }
        }