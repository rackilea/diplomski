slides.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent actionEvent){ 
    int timerDelay = 10 * 1000; // 10 seconds
    new Timer(timerDelay, new ActionListener() {
      private int count = 0;
      public void actionPerformed(ActionEvent evt){ 
        if (count < maxCount) {
          // code to show the team data for the count index
          count++;
        } else {
          ((Timer) evt.getSource()).stop(); // stop timer
        }
      }
    }).start();
  }
});