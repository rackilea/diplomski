import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableWithPrepareRendererExample extends JFrame {
  ColorName colors[] = { new ColorName("Red"), new ColorName("Green"), new ColorName("Blue"),
    new ColorName("Black"), new ColorName("White") };

  public TableWithPrepareRendererExample() {
    super("Table With prepareRenderer Example");
    setSize(500, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JTable table = new JTable(new AbstractTableModel() {
      ColorName data[] = { colors[0], colors[1], colors[2], colors[3], colors[4], colors[0],
        colors[1], colors[2], colors[3], colors[4] };


      public int getColumnCount() {
        return 3;
      }

      public int getRowCount() {
        return 10;
      }

      public Object getValueAt(int r, int c) {
        switch (c) {
          case 0:
            return (r + 1) + ".";
          case 1:
            return "Some pithy quote #" + r;
          case 2:
            return data[r];
        }
        return "Bad Column";
      }

      public Class getColumnClass(int c) {
        if (c == 2)
          return ColorName.class;
        return String.class;
      }

      public boolean isCellEditable(int r, int c) {
        return c == 2;
      }

      public void setValueAt(Object value, int r, int c) {
        data[r] = (ColorName) value;
      }

    }) {
      public Component prepareRenderer(TableCellRenderer renderer,
                                       int rowIndex, int vColIndex) {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        Object value = getValueAt(rowIndex, vColIndex);
        if (value.toString().equals("Red"))
          c.setBackground(Color.RED);
        else {
          if (rowIndex % 2 == 0 && !isCellSelected(rowIndex, vColIndex)) {
            c.setBackground(Color.YELLOW);
          } else {
            // If not shaded, match the table's background
            c.setBackground(getBackground());
          }
        }
        return c;
      }
    };

    JComboBox combo = new JComboBox(colors);
    table.setDefaultEditor(ColorName.class, new DefaultCellEditor(combo));
    table.setRowHeight(20);
    getContentPane().add(new JScrollPane(table));
  }

  public static void main(String args[]) {
    TableWithPrepareRendererExample ex = new TableWithPrepareRendererExample();
    ex.setVisible(true);
  }

  public class ColorName {
    String cname;

    public ColorName(String name) {
      cname = name;
    }

    public String toString() {
      return cname;
    }
  }

}