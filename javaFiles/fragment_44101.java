public class TestTimer {
     private JLabel label;
     Timer countdownTimer;
     int timeRemaining = 10;

     public TestTimer(JLabel passedLabel) {
        countdownTimer = new Timer(1000, new CountdownTimerListener());
        this.label = passedLabel;
        countdownTimer.start();
     }

      class CountdownTimerListener implements ActionListener {
          public void actionPerformed(ActionEvent e) {
             if (--timeRemaining > 0) {
                 label.setText(String.valueOf(timeRemaining));
              } else {
                 label.setText("Time's up!");
                 countdownTimer.stop();
              }
          }
      }
  }