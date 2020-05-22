JTextField tCounter=new JTextField();

void updateLabel(){
  tCounter.setText(currentNumber+"");
}


public void IncrementCounter() {
  currentNumber++;
  updateLabel()
}

...