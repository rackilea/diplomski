//the query
String sql = "SELECT " + "*" +
                " FROM " + table + 
                " WHERE " + selection;

//create the statement
PreparedStatement stmt = connection.prepareStatement(sql);

//bind the values
for(int i = 0; i < selectionArgs.length; i++) {
    stmt.setString(i, selectionArgs[i]); //i is "the nth question mark"
}

//execute the query and get the result set back
ResultSet rs = stmt.executeQuery();