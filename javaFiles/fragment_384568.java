List<String> queries = new ArrayList<String>();
for(Entry<String, List<String>> resultEntry : resultMap.entrySet()) {
   String tableName = resultEntry.getKey();
   List<String> columns = resultEntry.getValue();
   StringBuilder query = new StringBuilder(" select ");
   int i = 0;
   for(String column : columns) {
       query.append(column);
       if(i != columns.size()) {
          query.append(", ");
       } 
       i++;
   }
   query.append(" from ").append(tableName);
   queries.add(query.toString());
}