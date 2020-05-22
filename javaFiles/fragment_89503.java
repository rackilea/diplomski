private void startTimer() {

    new CountDownTimer(3000, 1000) {
        int secondsLeft = 0;

        public void onTick(long ms) {
            if (Math.round((float) ms / 1000.0f) != secondsLeft) {
                secondsLeft = Math.round((float) ms / 1000.0f);
                // resend_timer is a textview
                 resend_timer.setText("remaining time is "+secondsLeft);
                ;
            }
        }

        public void onFinish() {
            Log.d(TAG, "timer finished "+REPEAT_COUNT);
            if (REPEAT_COUNT <= NUM_REPEAT) {
                startTimer();
                REPEAT_COUNT++;
            }

        }
    }.start();
}