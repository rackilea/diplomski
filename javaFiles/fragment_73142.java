private final static int time = 10000;
private CountDownTimer timerCount;

public void countDown(){
    countDown = (TextView) findViewById(R.id.countdown);

            timerCount = new CountDownTimer(time, 1000) {

                public void onTick(long millisUntilFinished) {
                    long tmp = millisUntilFinished / 1000;
                    countDown.setText(tmp + "");
                }

                public void onFinish() {
                                    // Do your stuff
                    countDown.setText("0");
                                }
            }.start();
}