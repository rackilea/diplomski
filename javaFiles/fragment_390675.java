private List<Map<String, Object>> resultSetToListMap(ResultSet resultSet) throws SQLException {
    int columnCount = resultSet.getMetaData().getColumnCount();
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    while (resultSet.next()) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        for (int i = 1; i <= columnCount; i++) {
            map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
        }

        list.add(map);
    }

    return list;
}