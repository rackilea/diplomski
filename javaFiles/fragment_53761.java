int additionalCounter = 0;

ButtonPlus.setOnTouchListener(new View.OnTouchListener() {

  @Override
  public boolean onTouch(View v, MotionEvent event) {

    ++additionalCounter;
    if (additionalCounter % X == 0) {
      ponts = ponts + 1;
      resultTextView.setText(Integer.toString(ponts));
    }

  }  
});