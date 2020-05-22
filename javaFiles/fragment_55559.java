static void dumpResultSet(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columnCount = md.getColumnCount();
    PrintStream out = System.out;
    while (rs.next()) {
        out.print("{\n");
        for (int i=1; i<=columnCount; i++) {
            out.print("    ");
            out.print(md.getColumnLabel(i));
            out.print(": ");
            out.print(rs.getObject(i));

            if (i<columnCount-1) {
                out.print(", ");
            }
            out.print("\n");
        }
        out.print("}\n");
    }
}

Connection con = ...;
DatabaseMetaData md = con.getMetaData();

dumpResultSet(md.getTables(null, null, null, new String[]{"TABLE", "VIEW"}));
dumpResultSet(md.getColumns(null, null, "TABLE_NAME", null));
dumpResultSet(md.getExportedKeys(null, null, "TABLE_NAME"));
dumpResultSet(md.getImportedKeys(null, null, "TABLE_NAME"));
dumpResultSet(md.getPrimaryKeys(null, null, "TABLE_NAME"));
dumpResultSet(md.getIndexInfo(null, null, "TABLE_NAME", false, true));