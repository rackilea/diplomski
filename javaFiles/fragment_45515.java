public class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // Add additional graphics operations here.
    }
  }

  final JPanel panel = new MyPanel();
  int delay = 200; // Milliseconds

  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          panel.repaint();
      }
  };

  new Timer(delay, taskPerformer).start();