import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class BoolColorTable {
   @SuppressWarnings("serial")
   private static void createAndShowGui() {
      // null just to test how code will react to this situation
      // that hopefully won't occur
      Boolean[][] data = { null, { true }, { false }, { true }, { false },
            { false }, { true } };
      String[] colNames = { "Data" };
      DefaultTableModel model = new DefaultTableModel(data, colNames);
      JTable table = new JTable(model) {
         @Override
         public Class<?> getColumnClass(int column) {
            if (column == 0) {
               return Boolean.class;
            }
            return super.getColumnClass(column);
         }
      };

      table.setDefaultRenderer(Boolean.class, new BooleanRenderer());
      table.setDefaultEditor(Boolean.class, new BooleanEditor());

      JScrollPane mainPanel = new JScrollPane(table);

      JFrame frame = new JFrame("BoolColorTable");
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

@SuppressWarnings("serial")
class BooleanRenderer extends JLabel implements TableCellRenderer {
   public BooleanRenderer() {
      setOpaque(true);
   }

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
         boolean isSelected, boolean hasFocus, int row, int column) {
      Boolean boolValue = (Boolean) value;
      if (boolValue == null) {
         setBackground(null);
      } else {
         if (!boolValue) {
            this.setBackground(Color.red);
         } else {
            this.setBackground(Color.BLACK);
         }
      }
      return this;
   }
}

@SuppressWarnings("serial")
class BooleanEditor extends AbstractCellEditor implements TableCellEditor {

   JComboBox<Boolean> combo = new JComboBox<Boolean>(new Boolean[] {
         Boolean.TRUE, Boolean.FALSE });

   public BooleanEditor() {
      combo.setRenderer(new DefaultListCellRenderer() {
         @Override
         public Component getListCellRendererComponent(JList<?> list,
               Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Boolean boolValue = (Boolean) value;
            String displayString = "";
            if (boolValue == null) {
               displayString = "";
            } else if (boolValue) {
               displayString = "T";
            } else {
               displayString = "F";
            }
            return super.getListCellRendererComponent(list, displayString,
                  index, isSelected, cellHasFocus);
         }
      });
   }

   @Override
   public Object getCellEditorValue() {
      return combo.getSelectedItem();
   }

   @Override
   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      if (value == null) {
         combo.setSelectedIndex(-1);
      } else {
         combo.setSelectedItem((Boolean) value);
      }
      return combo;
   }
}