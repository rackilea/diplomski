**Column Row Mapper Class :**

@Override
public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    Map<String, Object> mapOfColumnValues = createColumnMap(columnCount);
    for (int i = 1; i <= columnCount; i++) {
        String column = JdbcUtils.lookupColumnName(rsmd, i);
        mapOfColumnValues.put(getColumnKey(column), getColumnValue(rs, i));
    }
    return mapOfColumnValues;
}