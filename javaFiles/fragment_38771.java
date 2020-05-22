public class ChildFrame extends JFrame {
  private Container parentContainer;
  public ChildFrame(Container parentContainer) {
    this.parentContainer = parentContainer;
    this.setSize(400, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout(FlowLayout.CENTER));
    JButton button = new JButton("Change Frame Color");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getRoot(parentContainer);
        frame.getContentPane().setBackground(Color.RED);
      }
    });
    this.getContentPane().add(button);
  }
}