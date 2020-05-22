public class ParentFrame extends JFrame {
    public ParentFrame() {
    this.setSize(400, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton button = new JButton("Open Window");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new ChildFrame(getContentPane()).setVisible(true);
      }
    });
    this.getContentPane().add(button);
  }
  public static void main(String[] args) {
    new ParentFrame().setVisible(true);
  }
}