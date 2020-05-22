public static void simplePrint(ResultSet rs) throws SQLException {
    ResultSetMetaData meta = rs.getMetaData();
    while (rs.next()) {
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.print(rs.getObject(i)+"\t");
        }
        System.out.println();
    }
}