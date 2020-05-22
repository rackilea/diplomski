import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestListRenderer extends JPanel {
   private static final int TOTAL_ITEMS = 100;
   private static final int MAX_VALUE = 15;
   private static final int VISIBLE_ROW_COUNT = 15;
   private DefaultListModel<Integer> listModel = new DefaultListModel<>();
   private JList<Integer> myList = new JList<>(listModel);
   private Random random = new Random();

   public TestListRenderer() {
      for (int i = 0; i < TOTAL_ITEMS; i++) {
         listModel.addElement(random.nextInt(MAX_VALUE));
      }

      myList.setCellRenderer(new MyListCellRenderer());

      myList.setVisibleRowCount(VISIBLE_ROW_COUNT);
      add(new JScrollPane(myList));
   }

   private class MyListCellRenderer extends DefaultListCellRenderer {
      private static final int PREF_W = 50;
      private static final int MAX_INT_VALUE = 10;
      private final Color HIGH_VALUE_FG = Color.white;
      private final Color HIGH_VALUE_BG = Color.red;

      @Override
      public Dimension getPreferredSize() {
         Dimension superSize = super.getPreferredSize();
         return new Dimension(PREF_W, superSize.height);
      }

      @Override
      public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
         Component superRenderer = super.getListCellRendererComponent(list, value, index, isSelected,
               cellHasFocus);

         setBackground(null);
         setForeground(null);
         if (value != null && ((Integer) value).intValue() > MAX_INT_VALUE) {
            setBackground(HIGH_VALUE_BG);
            setForeground(HIGH_VALUE_FG);
         }

         return superRenderer;
      }
   }

   private static void createAndShowGui() {
      TestListRenderer mainPanel = new TestListRenderer();

      JFrame frame = new JFrame("TestListRenderer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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