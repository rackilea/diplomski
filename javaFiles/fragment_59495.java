private void gameLoop() {
  int timerDelay = 100;
  new Timer(timerDelay, new ActionListener() {
     private final int maxIndex = 20;
     private int index = 0;

     @Override
     public void actionPerformed(ActionEvent e) {
        if (index < maxIndex) {
           states = Maths.render(box, frame, states);
           frame.validate();
           frame.repaint();
      } else {
           ((Timer) e.getSource()).stop();
        }
        index++;
     }
  }).start();
}