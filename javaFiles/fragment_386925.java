Map<String, List<String>> map = new HashMap<String, List<String>>();
ResultSet rs = st.executeQuery(sql);        
while (rs.next()) { 
    String table = rs.getString("table_name"));
    ArrayList<String> columns = map.get(table);
    if (columns == null) {
        columns = new ArrayList<String>();
        map.put(table, columns)
    }
    columns.add(rs.getString("column_name"));
}