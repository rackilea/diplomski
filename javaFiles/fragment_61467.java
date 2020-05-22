List<String> columnNames = new LinkedList<>();
Map<String,List<String>> columnNameToValuesMap=new HashMap<String, List<String>>();

 for (int i = 1; i <= columnCount; i++) {
        String columnName = rsmd.getColumnName(i);
        columnNames.add(columnName);

        //Load the Map initially with keys(columnnames) and empty list
        columnNameToValuesMap.put(columnName, new ArrayList());
 }

 try {
    while (rs.next()) { //Iterate the resultset for each row

      for (String columnName : columnNames) {
         //Get the list mapped to column name
         List<String> columnDataList = columnNameToValuesMap.get(columnName);

          //Add the current row's column data to list
          columnDataList.add(rs.getString(columnName));

          //add the updated list of column data to the map now
          columnNameToValuesMap.put(columnName, columnDataList);
        }
     }
 } catch (SQLException e) {
    e.printStackTrace();
}