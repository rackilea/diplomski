mTrueButton.setEnabled(false);
mFalseButton.setEnabled(false);

checkAnswer(false); //Display the appropriate Toast

new Handler().postDelayed(new Runnable() {
  @Override
  public void run() {
      mTrueButton.setEnabled(true);
      mFalseButton.setEnabled(true);
  }
}, 1500);