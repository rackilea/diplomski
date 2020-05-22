import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Abstract base class which extends from {@code AbstractTableModel} and 
 * provides an API to work with user-defined POJO's as table rows. Subclasses 
 * extending from {@code DataObjectTableModel} must implement 
 * {@code getValueAt(row, column)} method. 
 * <p />
 * By default cells are not editable. If those have to be editable then 
 * subclasses must override both {@code isCellEditable(row, column)} and 
 * {@code setValueAt(row, column)} methods.
 * <p />
 * Finally, it is not mandatory but highly recommended to override 
 * {@code getColumnClass(column)} method, in order to return the appropriate 
 * column class: default implementation always returns {@code Object.class}.
 * 
 * @param <T> The class handled by this TableModel.
 * @author dic19
 */
public abstract class DataObjectTableModel<T> extends AbstractTableModel {

    private final List<String> columnNames;
    private final List<T> data;

    public DataObjectTableModel() {
        this.data = new ArrayList<>();
        this.columnNames = new ArrayList<>();
    }

    public DataObjectTableModel(List<String> columnIdentifiers) {
        this();
        if (columnIdentifiers != null) {
            this.columnNames.addAll(columnIdentifiers);
        }
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columnNames.get(columnIndex);
    }

    public void setColumnNames(List<String> columnNames) {
        if (columnNames != null) {
            this.columnNames.clear();
            this.columnNames.addAll(columnNames);
            fireTableStructureChanged();
        }
    }

    public List<String> getColumnNames() {
        return Collections.unmodifiableList(this.columnNames);
    }

    public void addDataObject(T dataObject) {
        int rowIndex = this.data.size();
        this.data.add(dataObject);
        fireTableRowsInserted(rowIndex, rowIndex);
    }

    public void addDataObjects(List<T> dataObjects) {
        if (!dataObjects.isEmpty()) {
            int firstRow = data.size();
            this.data.addAll(dataObjects);
            int lastRow = data.size() - 1;
            fireTableRowsInserted(firstRow, lastRow);
        }
    }

    public void insertDataObject(T dataObject, int rowIndex) {
        this.data.add(rowIndex, dataObject);
        fireTableRowsInserted(rowIndex, rowIndex);
    }

    public void deleteDataObject(int rowIndex) {
        if (this.data.remove(this.data.get(rowIndex))) {
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void notifyDataObjectUpdated(T domainObject) {
        T[] elements = (T[])data.toArray();
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == domainObject) {
                fireTableRowsUpdated(i, i);
            }
        }
    }

    public T getDataObject(int rowIndex) {
        return this.data.get(rowIndex);
    }

    public List<T> getDataObjects(int firstRow, int lastRow) {
        List<T> subList = this.data.subList(firstRow, lastRow);
        return Collections.unmodifiableList(subList);
    }

    public List<T> getDataObjects() {
        return Collections.unmodifiableList(this.data);
    }

    public void clearTableModelData() {
        if (!this.data.isEmpty()) {
            int lastRow = data.size() - 1;
            this.data.clear();
            fireTableRowsDeleted(0, lastRow);
        }
    }
}