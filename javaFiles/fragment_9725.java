String sql = "{call dbo.usp_assignPartToShelf(?,?,?,?,?)}";
try (CallableStatement s = conn.prepareCall(sql)) {
    s.setString(1, "testItemNumber");
    s.setString(2, "testShelfNumber");

    SQLServerDataTable dt = new SQLServerDataTable();
    dt.addColumnMetadata("ItemNumber", Types.INTEGER);
    dt.addColumnMetadata("ShelfNumber", Types.INTEGER);
    ((SQLServerCallableStatement) s).setStructured(3, "dbo.udtt_ItemShelfPair", dt);

    s.registerOutParameter(4, Types.INTEGER);
    s.setString(5, "testDoerTicket");

    boolean hasResultSet = s.execute();
    if (hasResultSet) {
        try (ResultSet rs = s.getResultSet()) {
            rs.next();
            System.out.printf("ResultSet data: %s%n", rs.getString(1));
        }
    }
    System.out.printf("Output parameter data: %d%n", s.getInt(4));
}