@Override
public void tableChanged(TableModelEvent e) {
    AbstractTableModel model = (AbstractTableModel) e.getSource();
    TableModelListener[] listeners = model.getTableModelListeners();
    for (TableModelListener listener : listeners) {
        if (listener instanceof JTable) {
            System.out.println(((JTable)listener).getName());
        }
    }
}