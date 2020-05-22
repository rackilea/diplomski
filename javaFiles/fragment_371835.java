List<String> columns = new ArrayList<String>(); 
  try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + dbFileSpec);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM [" + tableName + "] WHERE False")) {
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Column names as reported by ResultSetMetaData:");
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i));
            columns.add(rsmd.getColumnName(i));
        }            
    } catch (SQLException e) {
        e.printStackTrace();
    }