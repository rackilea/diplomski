// start method name should start with a lower-case letter
public void start() {
  final Level player = new Level();
  frame.add(player);
  player.repaint();

  int fps = 1000 / FRAMES_PER_SEC;

  // use a field called timer
  timer = new Timer(fps, new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
        // get this out of the paintComponent method
        x += dx;
        y += dy;
        player.repaint();
     }
  });
  timer.start();
}