import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableFilterDemo2 {
  public JComponent makeUI() {
    String[] columnNames = {"Item"};
    Object[][] data = {{"G"}, {"KG"}, {"XG"}, {"Y"}, {"Z"}, {"*G"}};
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
    JTable table = new JTable(model);
    table.setRowSorter(sorter);

    JTextField textField = new JTextField("G");

    JButton button = new JButton("Toggle filter");
    button.addActionListener(e -> {
      if (sorter.getRowFilter() != null) {
        sorter.setRowFilter(null);
      } else {
        String text = Pattern.quote(textField.getText());
        String regex = String.format("^%s$", text);
        sorter.setRowFilter(RowFilter.regexFilter(regex));
      }
    });

    JPanel p = new JPanel(new BorderLayout());
    p.add(textField, BorderLayout.NORTH);
    p.add(new JScrollPane(table));
    p.add(button, BorderLayout.SOUTH);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new JTableFilterDemo2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}