import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @see https://stackoverflow.com/q/39993746/230513
 */
public class TableComboTest {

    private Vector<Vector<String>> createData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (int i = 0; i < 5; i++) {
            Vector<String> rowVector = new Vector<String>();
            rowVector.add(String.valueOf(i));
            rowVector.add("name");
            rowVector.add(String.valueOf(i + 1));
            rowVector.add(String.valueOf(i + 1));
            rowVector.add(String.valueOf(i + 1));
            data.add(rowVector);
        }
        return data;
    }

    private void display() {
        Vector<Vector<String>> data = createData();
        Vector<String> names = new Vector<>(Arrays.asList("ID", "Name", "OK", "Other", "Error"));
        DefaultTableModel tableModel = new DefaultTableModel(data, names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return column > 1;
            }
        };
        JTable table = new JTable(tableModel) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(getPreferredSize().width, getRowHeight() * 4);
            }
        };

        TableColumn column_ok = table.getColumnModel().getColumn(2);
        TableColumn column_other = table.getColumnModel().getColumn(3);
        TableColumn column_error = table.getColumnModel().getColumn(4);

        String[] choices = new String[]{"1", "2", "3", "4", "5"};
        JComboBox<String> combobox_ok = new JComboBox<>(choices);
        JComboBox<String> combobox_other = new JComboBox<String>(choices);
        JComboBox<String> combobox_error = new JComboBox<String>(choices);

        column_ok.setCellEditor(new DefaultCellEditor(combobox_ok));
        column_other.setCellEditor(new DefaultCellEditor(combobox_other));
        column_error.setCellEditor(new DefaultCellEditor(combobox_error));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TableComboTest()::display);
    }
}