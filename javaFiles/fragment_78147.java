import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            JTable table = new JTable(new MultiplicationTableMode());
            add(new JScrollPane(table));
        }

    }

    public class MultiplicationTableMode extends AbstractTableModel {

        private List<List<Integer>> values;

        public MultiplicationTableMode() {
            values = new ArrayList<>(1);
            List<Integer> cols = new ArrayList<>(11);
            for (int index = 0; index < 11; index++) {
                cols.add(0);
            }
            values.add(cols);
        }

        @Override
        public int getRowCount() {
            return values.size();
        }

        @Override
        public int getColumnCount() {
            return 10;
        }

        @Override
        public String getColumnName(int column) {
            return column == 0 ? "?" : "x" + Integer.toString(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            List<Integer> columns = values.get(rowIndex);
            return columns.get(columnIndex);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Integer.class;
        }


        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                if (aValue instanceof Integer) {
                    List<Integer> columns = values.get(rowIndex);
                    int intValue = (int) aValue;
                    columns.set(0, intValue);
                    for (int index = 1; index < columns.size(); index++) {
                        columns.set(index, intValue * index);
                    }
                    fireTableRowsUpdated(rowIndex, rowIndex);
                }
            }
        }

    }

}