package test;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;


public class TableTest {

  public static void main(String[] args) {
    TableTest tt = new TableTest();
    tt.start();
  }

  private void start() {
    JTable t = new JTable(new AbstractTableModel() {
      private static final long serialVersionUID = 1L;
      private List<Double> values = new ArrayList<Double>();
      {
        values.add(Double.valueOf(179.70d));
        values.add(Double.valueOf(299.40d));
        values.add(Double.valueOf(478.80d));
        values.add(Double.valueOf(89.85d));
      }
      @Override
      public String getColumnName(int column) {
        return "Double";
      }
      @Override
      public Class<?> getColumnClass(int column) {
        return Double.class;
      }
      @Override
      public int getRowCount() {
        return values.size();
      }
      @Override
      public int getColumnCount() {
        return 1;
      }
      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        return values.get(rowIndex);
      }
    });
    t.setDefaultRenderer(Double.class, new DefaultTableCellRenderer() {
      private static final long serialVersionUID = 1L;
      @Override
      public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus, int row,
          int column) {
        Double d = (Double)value;
        String s = "$" + String.valueOf(d.doubleValue());
        Component c = super.getTableCellRendererComponent(table, s, isSelected, hasFocus,
            row, column);
        return c;
      }
    });
    t.setAutoCreateRowSorter(true);
    JFrame f = new JFrame();
    f.setSize(320, 200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JScrollPane sp = new JScrollPane(t);
    f.getContentPane().add(sp);
    f.setVisible(true);
  }

}