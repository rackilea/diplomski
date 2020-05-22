import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ResizeCursorTest {
  public JComponent makeUI() {
    JTable table = new JTable(new DefaultTableModel(10, 3));

    TableColumnModel colModel = table.getColumnModel();
    colModel.getColumn(0).setMinWidth(15);
    colModel.getColumn(0).setMaxWidth(15);
    colModel.getColumn(0).setPreferredWidth(15);
    colModel.getColumn(0).setResizable(false);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ResizeCursorTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}