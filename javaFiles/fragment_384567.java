Map<String, List<String>> resultsMap = new HashMap<String, List<String>>();
ResultSet reportQuery_rst= reportQueryPS.executeQuery();
if(reportQuery_rst!=null){
   while (reportQuery_rst.next()) {
      String tableName = reportQuery_rst.getString("tablename");
      List<String> columns = resultsMap.get(tableName); 
      if(columns == null ) { 
          columns = new ArrayList<String>();
          resultMap.put(tableName, columns);
      }
      columns = resultsMap.get(tableName);
      String columnName = reportQuery_rst.getString("columnname");
      columns.add(columnName);
   }
}