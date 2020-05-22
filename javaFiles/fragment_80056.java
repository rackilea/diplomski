public void onClick(View v) {
// TODO Auto-generated method stub
  if (!answered)
  {
    add = getNextAnswer();
    display.setText(getCurrentQuestion() + add); 
  } else
    display.setText(getNextQuestion());
  answered=!answered;
}