public class HTMLTest {    

      public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            String html = "<ul><li>Cautious</li><li>Curious</li></ul>";
            JEditorPane pane = new JEditorPane("text/html", html) {

              public void paint(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paint(g2d);
                g2d.dispose();
              }

            };
            pane.setVisible(true);

            JOptionPane.showMessageDialog(null, pane);
          }
        });    
      }
}