import javax.swing.*;
import javax.swing.table.*;

/** @see https://stackoverflow.com/a/13628183/230513 */
public class ExampleRemoveAddRows extends JFrame {

    public static final String NEGATIVE = "negativ";
    public static final String POSITIVE = "positiv";
    private Object[] columnNames = {"Double", POSITIVE + " / " + NEGATIVE};
    private Object[][] data = {
        {10d, null},
        {-10.0, null},
        {Double.valueOf(30), null},
        {Double.valueOf("-30"), null}
    };
    private JTable table;
    private DefaultTableModel model;

    public ExampleRemoveAddRows() {
        model = new DefaultTableModel(data, columnNames) {

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }

            @Override
            public Object getValueAt(int row, int col) {
                if (col == 1) {
                    double number = (Double) this.getValueAt(row, 0);
                    return (number < 0) ? NEGATIVE : POSITIVE;
                } else {
                    return super.getValueAt(row, col);
                }
            }

            @Override
            public void setValueAt(Object aValue, int row, int col) {
                super.setValueAt(aValue, row, col);
                fireTableCellUpdated(row, 1); // may have changed
            }
        };
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

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
}