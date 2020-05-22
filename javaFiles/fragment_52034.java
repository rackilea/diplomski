int timerDelay = 500;
  new Timer(timerDelay, new ActionListener() {
     private boolean firstIcon = true;
     private int count = 0;

     @Override
     public void actionPerformed(ActionEvent e) {
        if (count >= MAX_COUNT) {
           ((Timer) e.getSource()).stop(); // stop the timer
           return;
        }

        // swap icons
        Icon icon = firstIcon ? icon1 : icon2;
        label.setIcon(icon);
        firstIcon = !firstIcon;
        count++;
     }
  }).start();