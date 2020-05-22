// LABEL_SWAP_TIMER_DELAY a constant int = 3000
javax.swing.Timer myTimer = new javax.swing.Timer(LABEL_SWAP_TIMER_DELAY, 
      new ActionListener(){
  private int timerCounter = 0;

  actionPerformed(ActionEvent e) {
    // iconArray is an array of ImageIcons that holds your four icons.
    imgLbl.setIcon(iconArray[timerCounter]);
    timerCounter++;
    timerCounter %= iconArray.length;
  }
});
myTimer.start();