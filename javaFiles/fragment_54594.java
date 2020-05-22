import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;

public class TestCenterLayout extends JPanel{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Color BACKGROUND = Color.pink;

   public TestCenterLayout() {
      setBorder(BorderFactory.createTitledBorder("800 x 600 Panel"));
      setBackground(BACKGROUND);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Test Center Layout");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new GridBagLayout());
      frame.getContentPane().add(new TestCenterLayout());
      frame.pack();
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}