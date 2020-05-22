String query = "select * from table where columnName in (:listOfValues)";
List<String> nameRecordIDs = new ArrayList<String>(); 
// ...
// add values to collection, then
// ...
Map namedParameters = Collections.singletonMap("listOfValues", nameRecordIDs);
namedparameterJdbcTemplate.query(query, namedParameters,new MyMapper());