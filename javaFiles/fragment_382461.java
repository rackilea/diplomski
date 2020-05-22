import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.event.*;
import java.util.EventObject;

public class ButtonInTable {

  public static void main(String[] args) {

    DefaultTableModel tableModel = new DefaultTableModel(
        new Object[][] {
            {"aa", "aaa", ""},
            {"bb", "bbb", ""},
            {"cc", "ccc", ""},
            {"dd", "ddd", ""},
            {"ee", "eee", ""}},
        new Object[] {"Column 1", "Column 2", " "});
    JTable table = new JTable(tableModel);
    table.getColumn(" ").setCellRenderer(new RendererAndEditor(table));
    table.getColumn(" ").setCellEditor(new RendererAndEditor(table));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}

class RendererAndEditor implements TableCellRenderer, TableCellEditor {

  private JButton button;
  private int row;

  RendererAndEditor(JTable table) {
    button = new JButton("Delete");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.removeRow(row);
      }
    });
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {
    return button;
  }

  @Override
  public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                        int column) {
    this.row = row;
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    return null;
  }

  @Override
  public boolean isCellEditable(EventObject anEvent) {
    return true;
  }

  @Override
  public boolean shouldSelectCell(EventObject anEvent) {
    return true;
  }

  @Override
  public boolean stopCellEditing() {
    return true;
  }

  @Override
  public void cancelCellEditing() { }

  @Override
  public void addCellEditorListener(CellEditorListener l) { }

  @Override
  public void removeCellEditorListener(CellEditorListener l) { }
}