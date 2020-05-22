List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
ResultSetMetaData metaData = resultSet.getMetaData();
int columnCount = metaData.getColumnCount();

while (resultSet.next()) {
    Map<String, Object> columns = new LinkedHashMap<String, Object>();

    for (int i = 1; i <= columnCount; i++) {
        columns.put(metaData.getColumnLabel(i), resultSet.getObject(i));
    }

    rows.add(columns);
}