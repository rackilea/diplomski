public ArrayList<String> getReport(String name) {
    try {
        Statement sql =  mySql.getConnection().createStatement();
        ResultSet resultSet = sql.executeQuery("SELECT * FROM `reports` WHERE `reportedplayer`='" + name + "';");
        if(!resultSet.next()) {
            sql.close();
            resultSet.close();
            return null;
        }
        ArrayList<String> rowValues = new ArrayList<String>();
        int columnCount = resultSet.getMetaData().getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int idx=0; idx<columnCount; idx++) {
            columnNames[idx] = resultSet.getMetaData().getColumnName(idx);
        }

        while (resultSet.next()) {
            for (String columnName: columnNames) {
                rowValues.add(resultSet.getString(columnName));
            }
        }
        sql.close();
        resultSet.close();
        return rowValues;
    }catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}