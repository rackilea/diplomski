StringBuilder sb = new StringBuilder();
String fetchColumn = "emp_id"; //take care of SQL injection if necessary
String tableName = Employee.class.getSimpleClassName();
sb.append("select ").append(fetchColumn)
    .append("from ").append(tableName);
String query = sb.toString();
// rest of your code here