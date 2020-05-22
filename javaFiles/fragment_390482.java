List<String> setClauses = new ArrayList<String>();
for (String key : columns.keySet()) {
    setClauses.add(String.format("%s=?", key));
}

// StringUtils is from Apache Commons Lang
// although it's pretty easy to build your own join routine. 
String command = String.format("UPDATE table SET %s WHERE id=?"
    , StringUtils.join(setClauses, ",")
);

PreparedStatement statement = connection.prepareStatement(command);
int p = 1;
for (String key : columns.keySet()) {
    statement.setString(p++, columns.get(key));
}
statement.setString(p++, id);