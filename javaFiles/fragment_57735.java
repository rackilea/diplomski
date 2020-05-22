public static class OrderTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {"Item", "Qty", "Amount"};
    private List<OrderModel> rows;

    public OrderTableModel(List<OrderModel> rows) {
        this.rows = new ArrayList<>(rows);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        OrderModel row = rows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = row.getItem();
                break;
            case 1:
                value = row.getQty();
                break;
            case 2:
                value = row.getAmount();
                break;
        }
        return value;
    }

}