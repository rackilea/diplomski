import java.awt.Component;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Test {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        Object[][] data = new Object[8][3];
        data[0][0] = 6.5d; data[0][1] = "Name1";
        data[1][0] = new NullClassFiller(); data[1][1] = "Name2";
        data[2][0] = 2.6d; data[2][1] = "Name3";
        data[3][0] = 0d; data[3][1] = "Name4";
        data[4][0] = new NullClassFiller(); data[4][1] = "Name5";
        data[5][0] = -4d; data[5][1] = "Name6";
        data[6][0] = 0d; data[6][1] = "Name7";
        data[7][0] = -4.3d; data[7][1] = "Name8";
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(data, new String[]{"One", "Two"}) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? Double.class : String.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel()) {
            @Override
            public Comparator<?> getComparator(final int column) {
                Comparator c = new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        boolean ascending = getSortKeys().get(column).getSortOrder() == SortOrder.ASCENDING;
                        System.out.println(o1.getClass() + " - " + o2.getClass());
                        if (o1 instanceof NullClassFiller) {
                            if(ascending)
                                return 1;
                            else
                                return -1;
                        } else if (o2 instanceof NullClassFiller) {
                            if(ascending)
                                return -1;
                            else
                                return 1;
                        } else {
                            return ((Comparable<Object>) o1).compareTo(o2);
                        }

                    }
                };
                return c;
            }
        };
        table.setRowSorter(sorter);
        table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class NullClassFiller {}

    static class CustomRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if(value instanceof NullClassFiller)
                renderer.setText("");

            return renderer;
        }

    }
}