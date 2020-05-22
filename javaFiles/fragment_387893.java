//the query
String sql = "SELECT " + "*" +
                " FROM " + table + 
                " WHERE documetFK = ?";

//create the statement
PreparedStatement stmt = connection.prepareStatement(sql);

//bind the value
stmt.setInt(1, 4); //1 is "the first question mark", 4 is some fk

//execute the query and get the result set back
ResultSet rs = stmt.executeQuery();