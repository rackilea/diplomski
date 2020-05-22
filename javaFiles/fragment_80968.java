timer = new CountDownTimer(10000, 1000) {

        public void onTick(long millisUntilFinished) {
            textQuestion.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            wrongAnswer();
        }
    }.start();