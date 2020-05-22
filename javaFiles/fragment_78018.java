import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name",
        "Size",
        "Directory",
        "Last Modified Time",
        "Readable"};

    List<List> rows;

    public MyTableModel() {
        rows = new ArrayList<>(25);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c) {
        // Don't do this, what happens if the cell value is null??
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        List columns = rows.get(row);
        columns.set(col, value);
        fireTableCellUpdated(row, col);
    }

    public void updateJarTable(Object[] row) {
        List columns = new ArrayList(row.length);
        columns.addAll(Arrays.asList(row));
        rows.add(columns);
        fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return rows.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        List columns = rows.get(rowIndex);
        return columns.get(rowIndex);
    }
}