public class cycle extends JApplet implements ActionListener {

  private JPanel panel;
  private JButton left;
  private JButton right;
  private Container c = getContentPane();

  public cycle() {
    panel = new JPanel();
    left = new JButton("left");
    right = new JButton("right");
    panel.add(left);
    panel.add(right);
    c.add(panel);
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setTitle("Move the ball");
    f.setSize(500, 500);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    f.add(new cycle());

    f.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}