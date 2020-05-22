DefaultRowSorter sorter = (DefaultRowSorter)table.getRowSorter();
sorter.setRowFilter(new RowFilter() {
    @Override
    public boolean include(RowFilter.Entry entry) {
        Boolean value = (Boolean)entry.getValue(2);
        return value == null || value;
    }
});
sorter.setSortsOnUpdates(true);