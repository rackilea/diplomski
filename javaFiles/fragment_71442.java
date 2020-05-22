private void startTimer() {
    countDownTimer = new CountDownTimer(timee, 1000) {
        @Override
        public void onTick(long l) {
            tv.setText(simpleDateFormat.format(l));
            timesLeft = l;
        }

        @Override
        public void onFinish() {
            tv.setText("00:00:00");
        }
    }.start();
}