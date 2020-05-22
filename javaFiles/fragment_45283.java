Connection con = mysql.createConnection();
String sql = "INSERT INTO main.users(first_name, last_name, email, password, city,
country, registered_time) VALUES(?, ?, ?, ?, ?, ?, ?);";
PreparedStatement insertStatement = con.prepareStatement(sql);
insertStatement.setString(1, first_name);
insertStatement.setString(2, last_name);
insertStatement.setString(3, email);
insertStatement.setString(4, password);
insertStatement.setString(5, city);
insertStatement.setString(6, country);
insertStatement.setString(7, new Date());
insertStatement.execute();