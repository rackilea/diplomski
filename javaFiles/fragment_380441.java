int i=0;
dbConnection = new DbConnection[tableLists.size()];
for (Map<String, String> map : tableLists.values()) {
  dbConnection[i] = getDBConnection(
    map.get("URL"), 
    map.get("USER"), 
    map.get("PASSWORD"), 
    map.get("DRIVER"));
  i++;
}