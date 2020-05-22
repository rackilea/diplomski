public class Visibility {
  private void makeGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JLabel l = new JLabel("Hello");
    final JButton b = new JButton("Hide Label");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        l.setVisible(false);
      }
    });

    f.getContentPane().setLayout(new BorderLayout());
    f.getContentPane().add(l, BorderLayout.CENTER);
    f.getContentPane().add(b, BorderLayout.SOUTH);
    f.setSize(200, 200);
    f.setLocation(200, 200);
    f.validate();
    f.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Visibility().makeGUI();
      }
    }); 
  }
}