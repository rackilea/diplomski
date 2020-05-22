import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


@SuppressWarnings("serial")
public class deleteRowTable extends JFrame {
   public deleteRowTable() {
      super();
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      this.add(getPreview());

      setSize(500, 500);
      setVisible(true);
   }

   public static void main(String args[]) {
      new deleteRowTable();
   }

   public Component getPreview() {
      // Table
      JTable table = new JTable(new ExampleTableModel());
      JScrollPane scrollPane = new JScrollPane(table);

      // Custom column
      TableColumn buttonColumn = table.getColumnModel().getColumn(0);

      // Custom renderer
      buttonColumn.setCellRenderer(new ButtonRenderer());

      // Custom editor
      buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

      return scrollPane;
   }

   public class ExampleTableModel extends AbstractTableModel {
      private String[] columnNames = { "Delete", "Values" };
      private Object[][] data = { { "-", "id1" }, { "-", "id2" },
            { "-", "id3" }, { "-", "id4" }, { "-", "id" } };

      public final Object[] longValues = { "-", "Value" };

      @Override
      public int getColumnCount() {
         return columnNames.length;
      }

      @Override
      public int getRowCount() {
         return data.length;
      }

      @Override
      public String getColumnName(int col) {
         return columnNames[col];
      }

      @Override
      public Object getValueAt(int row, int col) {
         return data[row][col];
      }

      @Override
      public Class<?> getColumnClass(int c) {
         return longValues[c].getClass();
      }

      @Override
      public boolean isCellEditable(int row, int col) {
         return true;
      }

      @Override
      public void setValueAt(Object value, int row, int col) {
         data[row][col] = value;
         fireTableCellUpdated(row, col);
      }
   }
}

@SuppressWarnings("serial")
class ButtonEditor extends DefaultCellEditor {
   protected JButton button;
   private String label;
   private boolean isPushed;
   private int myRow;
   private JTable table;

   public ButtonEditor(JCheckBox checkBox) {
      super(checkBox);
      button = new JButton();
      button.setOpaque(true);
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
         }
      });
   }

   @Override
   public Component getTableCellEditorComponent(JTable table, Object value,
         boolean isSelected, int row, int column) {
      this.myRow = row;
      this.table = table;
      if (isSelected) {
         button.setForeground(table.getSelectionForeground());
         button.setBackground(table.getSelectionBackground());
      } else {
         button.setForeground(table.getForeground());
         button.setBackground(table.getBackground());
      }
      label = (value == null) ? "" : value.toString();
      button.setText(label);
      isPushed = true;
      return button;
   }

   @Override
   public Object getCellEditorValue() {
      if (isPushed) {

         deleteRowTable.ExampleTableModel model = (deleteRowTable.ExampleTableModel) table.getModel();
         String label = (String) model.getValueAt(myRow, 1);
         if (label != null) {
            JOptionPane.showMessageDialog(button, "This is your label: " + label);
            // delete the model's row here if desired.
         }
      }
      isPushed = false;
      return new String(label);
   }

   @Override
   public boolean stopCellEditing() {
      isPushed = false;
      return super.stopCellEditing();
   }

   @Override
   protected void fireEditingStopped() {
      super.fireEditingStopped();
   }
}

@SuppressWarnings("serial")
class ButtonRenderer extends JButton implements TableCellRenderer {
   public ButtonRenderer() {
      setOpaque(true);
   }

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
         boolean isSelected, boolean hasFocus, int row, int column) {
      if (isSelected) {
         setForeground(table.getSelectionForeground());
         setBackground(table.getSelectionBackground());
      } else {
         setForeground(table.getForeground());
         setBackground(UIManager.getColor("Button.background"));
      }
      setText((value == null) ? "" : value.toString());
      return this;
   }
}