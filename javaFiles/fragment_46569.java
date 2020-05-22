import java.awt.EventQueue;
import java.util.List;

import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.*;
import javax.swing.table.*;

public class SortTest {

    private JFrame frame = new JFrame(getClass().getSimpleName());

    private DefaultTableModel model = new DefaultTableModel(10, 2) {
        private static final long serialVersionUID = 1L;

        @Override
        public Class<?> getColumnClass(int column) {
            return column == 1 ? Integer.class : Object.class;
        }
    };
    private JTable table = new JTable(model);

    public SortTest() {
        for (int row = model.getRowCount(); --row >= 0;) {
            int i = 20 + row % 20;
            model.setValueAt(row + " " + i, row, 0);
            model.setValueAt(i + row, row, 1);
        }
        table.setAutoCreateRowSorter(true);
        TableRowSorter<?> sorter = (TableRowSorter<?>) table.getRowSorter();
        sorter.setSortsOnUpdates(true);
        sorter.addRowSorterListener(new RowSorterListener() {

            @Override
            public void sorterChanged(RowSorterEvent rse) {
                if (rse.getType() == RowSorterEvent.Type.SORT_ORDER_CHANGED) {
                    List<SortKey> keys = rse.getSource().getSortKeys();
                    for (SortKey key : keys) {
                        System.out.println("Column NO. - " + key.getColumn() + " is sorted");
                        if (key.getColumn() == 0) {
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        });
        frame.add(new JScrollPane(table));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new SortTest();
        });
    }
}