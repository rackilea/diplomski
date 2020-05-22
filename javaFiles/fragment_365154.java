Connection conn = dataSource.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT ID FROM USERS");
...
rs.close();
stmt.close();
conn.close();