public class StaggerTest {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Stagger Test");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridBagLayout());

    placeComp(new JButton("1"), panel, 0, 0, 2, 1);
    placeComp(Box.createHorizontalStrut(10), panel, 2, 0, 1, 1);
    placeComp(Box.createHorizontalStrut(10), panel, 0, 1, 1, 1);
    placeComp(new JButton("2"), panel, 1, 1, 2, 1);

    frame.setContentPane(panel);

    frame.setVisible(true);
  }

  public static void placeComp(Component comp, JPanel panel, int x, int y, int w, int h) {
    GridBagConstraints cons = new GridBagConstraints();
    cons.gridx = x;
    cons.gridy = y;
    cons.gridwidth = w;
    cons.gridheight = h;
    panel.add(comp, cons);
  }
}