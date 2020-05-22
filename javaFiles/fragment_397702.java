import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


public class Relequestual extends JFrame {

   private final FunkyCellRendererComponent funkyCRC = new FunkyCellRendererComponent();

   public Relequestual() {
      getContentPane().setLayout(new FlowLayout());

      String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };
      JList theList = new JList(items);
      theList.setCellRenderer(
      new ListCellRenderer() {
         @Override
         public Component getListCellRendererComponent(JList list, Object value, int index,
               boolean isSelected, boolean cellHasFocus) {
            funkyCRC.setup(list, value, index, isSelected, cellHasFocus);
            return funkyCRC;
         }
      });
      getContentPane().add(theList);

   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      Relequestual gui = new Relequestual();
      gui.pack();
      gui.setVisible(true);
   }

   class FunkyCellRendererComponent extends JPanel {

      private JCheckBox checkBox = new JCheckBox();
      private JLabel label = new JLabel();
      private JList list;
      private int index;

      public FunkyCellRendererComponent() {
         super(null);
         setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
         add(this.checkBox);
         add(this.label);
      }

      public void setup(JList list, Object value, int index,
               boolean isSelected, boolean cellHasFocus) {
         this.list = list;
         this.index = index;
         this.label.setText((String) list.getModel().getElementAt(index)); 
         if (isSelected) {
            setForeground(list.getSelectionForeground());
            setBackground(list.getSelectionBackground());
         } else {
            setForeground(list.getForeground());
            setBackground(list.getBackground());
         }
         this.checkBox.setSelected(isSelected);
      }

   }

}