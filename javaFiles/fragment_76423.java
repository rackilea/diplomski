ActionListener a9 = new ActionListener(){
  private int count = 0;

  public void actionPerformed(ActionEvent evt){
    if (count < MAX_COUNT) { // MAX_COUNT is an int constant, here, 10

      // ... do something

    } else {
      // we're done -- stop the Timer
      ((Timer)evt.getSource()).stop();
    }
    count++;
  }
};