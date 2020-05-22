public static class MyTableModel extends AbstractTableModel {

    public enum Modify {
        ADD,
        REMOVE
    }

    public static class NewItem {
        public final Object entry;

        public NewItem(Object entry) {
            this.entry = entry;
        }
    }

    private List entries;

    public MyTableModel(List entries) {
        this.entries = entries;
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return entries.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue instanceof NewItem) {
            addEntry(((NewItem) aValue).entry);
        } else if (Modify.REMOVE == aValue) {
            removeEntry(rowIndex);
        } else {
            entries.set(rowIndex, aValue);
        }    
    }

    private void removeEntry(int rowIndex) {
        entries.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    private void addEntry(Object aValue) {
        int last = getRowCount();
        entries.add(aValue);
        fireTableRowsInserted(last, last);
    }


}