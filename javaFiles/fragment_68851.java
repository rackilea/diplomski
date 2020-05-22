public enum TableColumn {
    CUSTOMER_NAME("customer", "name"), CUSTOMER_ID("customer", "id"),
    ORDER_ID("order", "id"), // etc etc

    String table;
    String column;

    public TableColumn(String table, String column) {
        // set values
    }
}

public List<Row> doSelect(TableColumn tc, Object value) {
    String sql = String.format("select * from %s where %s = ?", tc.table, tc.column);
    Connection con = getConnection();
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1, value);
        ...