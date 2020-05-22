import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

/**
* @see https://stackoverflow.com/a/13628183/230513
*/
public class ExampleRemoveAddRows extends JFrame {

    public static final String NEGATIVE = "negativ";
    public static final String POSITIVE = "positiv";

    public ExampleRemoveAddRows() {
        DoubleModel model = new DoubleModel();
        model.add(10.1);
        model.add(-10.2);
        model.add(Double.valueOf(30.1));
        model.add(Double.valueOf("-30.2"));
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ExampleRemoveAddRows frame = new ExampleRemoveAddRows();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private class DoubleModel extends AbstractTableModel {

        List<Double> data = new ArrayList<Double>();

        public void add(Double d) {
            data.add(d);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int col) {
            if (col == 0) {
                return "Double";
            } else {
                return POSITIVE + " / " + NEGATIVE;
            }
        }

        @Override
        public Class<?> getColumnClass(int col) {
            if (col == 0) {
                return Double.class;
            } else {
                return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 0;
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (col == 0) {
                return data.get(row);
            } else {
                double number = (Double) this.getValueAt(row, 0);
                return (number < 0) ? NEGATIVE : POSITIVE;
            }
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            if (col == 0) {
                data.set(row, (Double) aValue);
                fireTableRowsUpdated(row, row);
            }
        }
    }
}