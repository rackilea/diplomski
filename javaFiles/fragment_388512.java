public class SomeJFrame extends JFrame {
   public SomeJFrame() {
      setLayout(new BorderLayout());

      JPanel parent = new JPanel(new BorderLayout());
      parent.setPreferredSize(new Dimension(200, 201));
      JPanel child = new JPanel(new BorderLayout());
      parent.add(child);
      System.out.println(child.getParent().getPreferredSize().getWidth());

      add(parent, BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new SomeJFrame();
         }
      });
   }

}