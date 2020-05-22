import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class BasicExample extends JFrame {
  private JTable t;
  private DefaultTableModel dtm;

  public BasicExample() {
    init();
  }

  private void init() {
    dtm = new DefaultTableModel(new String[][] { { "a", "b" }, { "c", "d" } },
        new String[] { "A", "B" });
    t = new JTable(dtm);

    t.getTableHeader().setComponentPopupMenu(new PopupMenu(t));
    this.setLayout(new BorderLayout());
    add(t.getTableHeader(), BorderLayout.NORTH);
    add(t, BorderLayout.CENTER);
    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public class PopupMenu extends JPopupMenu {

    private JTable table;

    public PopupMenu(JTable table) {
      this.table = table;
      init();
    }

    private void init() {
      for (int i = 0; i < table.getModel().getColumnCount(); i++) {
        String columnName = table.getModel().getColumnName(i);

        JMenuItem item = new JMenuItem(columnName);
        item.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            TableColumn tc = table.getColumn(columnName);

            t.getTableHeader().setDraggedColumn(null);

            table.getColumnModel().removeColumn(tc);
          }
        });
        this.add(item);
      }
    }
  }

  public static void main(String[] args) {
    BasicExample be = new BasicExample();
  }
}