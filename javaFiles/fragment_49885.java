private static final int CHECKBOX_COLUMN = 4;
...
RowFilter<TableModel, Integer> filter = new RowFilter<TableModel, Integer>() {
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
        int modelRow = entry.getIdentifier();
        Boolean checked = (Boolean)entry.getModel().getValueAt(modelRow, CHECKBOX_COLUMN);
        return checked;
    }
};