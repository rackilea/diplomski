import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.*;

public class TreeSetInJListTest extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final String[] DATA_ARRAY = { "one", "two", "three", "two",
         "three", "this is a longer string" };
   TreeSetListModel<String> stringListModel = new TreeSetListModel<String>(
         String.CASE_INSENSITIVE_ORDER);
   JList<String> jList = new JList<String>(stringListModel);

   public TreeSetInJListTest() {
      for (int i = 0; i < DATA_ARRAY.length; i++) {
         stringListModel.add(DATA_ARRAY[i]);
      }

      add(new JScrollPane(jList));
      add(new JButton(new AddToListAction("Add To List", KeyEvent.VK_A)));
   }

   @SuppressWarnings("serial")
   private class AddToListAction extends AbstractAction {
      public AddToListAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         String element = JOptionPane.showInputDialog(TreeSetInJListTest.this,
               "Enter String:", "Insert Text Into JList",
               JOptionPane.OK_CANCEL_OPTION);
         stringListModel.add(element);
      }
   }

   private static void createAndShowGui() {
      TreeSetInJListTest mainPanel = new TreeSetInJListTest();

      JFrame frame = new JFrame("Example");
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

class TreeSetListModel<T extends Comparable<T>> extends AbstractListModel<T> {
   private static final long serialVersionUID = 1L;
   private TreeSet<T> treeSet;

   public TreeSetListModel() {
      treeSet = new TreeSet<T>();
   }

   public TreeSetListModel(Comparator<? super T> comparator) {
      treeSet = new TreeSet<T>(comparator);
   }

   @Override
   public T getElementAt(int index) {
      if (index < 0 || index >= getSize()) {
         String s = "index, " + index + ", is out of bounds for getSize() = "
               + getSize();
         throw new IllegalArgumentException(s);
      }
      Iterator<T> iterator = treeSet.iterator();
      int count = 0;
      while (iterator.hasNext()) {
         T t = (T) iterator.next();
         if (index == count) {
            return t;
         }
         count++;
      }
      // out of index. return null. will probably never reach this
      return null;
   }

   @Override
   public int getSize() {
      return treeSet.size();
   }

   public int getIndexOf(T t) {
      int index = 0;
      for (T treeItem : treeSet) {
         if (treeItem.equals(treeItem)) {
            return index;
         }
         index++;
      }
      return -1;
   }

   public boolean add(T t) {
      boolean result = treeSet.add(t);
      if (result) {
         int index = getIndexOf(t);
         fireIntervalAdded(this, index, index + 1);
      }
      return result;
   }

   public boolean remove(T t) {
      int index = getIndexOf(t);
      if (index < 0) {
         return false;
      }
      boolean result = treeSet.remove(t);
      fireIntervalRemoved(this, index, index + 1);
      return result;
   }

}