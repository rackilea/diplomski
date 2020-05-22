private void start() {

    countDownTimer = new CountDownTimer(3000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText(String.valueOf((int) Math.ceil(millisUntilFinished / 1000.0)));
        }

        @Override
        public void onFinish() {
            time.setText("Click!");
        }
    };

    countDownTimer.start();
}