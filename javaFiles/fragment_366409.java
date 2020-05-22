String query =  "select test.col1, test.col2, test.col3" + 
  "from Test test " +
  "where {columnName} = :variableValue ";
Object variableValue = // retrieve from somewhere
String columnName = // another retrieve from somewhere
query = query.replace("{columnName}", columName);
// Now continue as always