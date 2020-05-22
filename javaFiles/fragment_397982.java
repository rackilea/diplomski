sorter.setRowFilter(new RowFilter<TableModel,Integer>() {
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        // only include rows that have a cat in column 0
        return row.getValue(0).toString().contains("cat");
    }
});