public class ScrollPaneTest {

  public static void main(String[] args) {
    new ScrollPaneTest();
  }

  public ScrollPaneTest() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        JPanel bigPane = new JPanel();
        bigPane.setBackground(Color.BLUE);
        // This is not recommended, but is used for demonstration purposes
        bigPane.setPreferredSize(new Dimension(1024, 768)); 

        JScrollPane scrollPane = new JScrollPane(bigPane);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }
}