Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//set the query, create the statement

ResultSet rs = stmt.executeQuery(sql);
//get values

conn.close();
rs.close();

//return values