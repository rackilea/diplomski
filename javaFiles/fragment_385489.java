public void myWinner(final Color flashColor) {
      int timerDelay = 300;
      new javax.swing.Timer(timerDelay , new ActionListener() {
         private static final int COUNTER_MAX = 5;
         int counter = 0;

         public void actionPerformed(ActionEvent e) {
            if (counter >= COUNTER_MAX) { // time to stop
               ((Timer)e.getSource()).stop();
               for (int i = 0; i < gridButton.length; i++) {
                  gridButton[i].setBackground(Color.white); // just to be sure
                  gridButton[i].setEnabled(true);
                  gridButtonOwner[i] = 0;
               }
            }
            Color bckgrndColor = (counter % 2 == 0) ? flashColor : Color.white;
            for (JButton button : gridButton) {
               button.setBackground(bckgrndColor);
            }
            counter++;
         }
      }).start();
   }