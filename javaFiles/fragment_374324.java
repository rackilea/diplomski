public class TimerBasedAnimation extends JPanel implements ActionListener {
  public void paint(Graphics g) {
      // setup
      // do some first-run init stuff
      // calculate the next frame
      // render frame
  }

  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("TimerBasedAnimation");
    frame.add(new TimerBasedAnimation());
    ...
  }
}