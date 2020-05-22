try {
    PreparedStatement sv = localConnection.prepareStatement("select * from " + tablename + " where " + tablepk_name + " = '" + tablepk + "'" + " and " + table_sc_name + " = '" + table_sc_id + "'");
    ResultSet rs_local = sv.executeQuery();
    while (rs_local.next()) {
       localConnection.setAutoCommit(false);
        rsmd = rs_local.getMetaData();
        final int columnCount = rsmd.getColumnCount();
        List<List<String>> rowList = new LinkedList<>();
        List<String> columnNames = null;
        String insertColumns = "";
        String insertValues = "";
        columnNames = new ArrayList<>();
        List<String> columnList = new LinkedList<>();
        rowList.add(columnList);
        for (int j = 1; j <= columnCount; j++) {
            columnNames.add(rsmd.getColumnLabel(j));
        }
        if (columnNames != null && columnNames.size() > 0) {
            insertColumns += columnNames.get(0);
            insertValues += "?";
        }
        for (int j = 1; j < columnNames.size(); j++) {
            insertColumns += "='?', " + columnNames.get(j);
            insertValues += ", " + "?";
        }
        SQL = "UPDATE " + tablename + " set " + insertColumns + " = ? where " + tablepk_name +" = '"+ tablepk + "'";
        PreparedStatement ps = localConnection.prepareStatement(SQL);
        for (int column = 1; column <= columnCount; column++) {
            Object value = rs_local.getObject(column);
            ps.setObject(column, value);
        }
        String psa = ps.toString();
        query = psa.substring(psa.indexOf(": ") + 2);
        System.out.println(" quer " + query);
    }
} catch (SQLException ex) {
    Logger.getLogger(PosSynchronizationPoll.class.getName()).log(Level.SEVERE, null, ex);
}