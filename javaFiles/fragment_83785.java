void startTimer() {
    cTimer = new CountDownTimer(10150, 1000) {
        public void onTick(long millisUntilFinished) {
            c.setText("Please wait " + millisUntilFinished/1000 + " seconds");
            thx.setText(millisUntilFinished/1000 + "");
            thx.setAlpha(.5f);
            thx.setClickable(false);

        }
        public void onFinish() {
        c.setText("done");
            thx.setText("ready");
            thx.setAlpha(1f);
            thx.setClickable(true);
        }
    };
    cTimer.start();
}