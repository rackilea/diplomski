//check if end of game
if (currentGame.isGameOver()) {
    Intent i = new Intent(this, EndgameActivity.class);
    startActivity(i);
    finish();
} else {
    if (mCountDown != null) { 
       mCountDown.cancel();
    }  
    currentQ = currentGame.getNextQuestion();
    setQuestions();
    mCountDown = new CountDownTimer(20000, 1000) {

        @Override
        public void onFinish() {
            // myCounter.setText("Time up!");
            timeUp(context);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            myCounter.setText("Time left: "
                    + String.valueOf(millisUntilFinished / 1000));
        }
    }.start();  
}