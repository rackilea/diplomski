Properties props = new Properties(); 
    props.put("user", "root");         
    props.put("password", "password");
    props.put("useUnicode", "true");
    props.put("useServerPrepStmts", "false"); // use client-side prepared statement
    props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

    String url = "jdbc:mysql://localhost/mydb";
    Connection connection = DriverManager.getConnection(url, props);

    PreparedStatement ps = 
        connection.prepareStatement("INSERT INTO list (Name, Number) VALUES (?, ?)");

    String testNumber = "12345";
    String testName = "name1";
    pstmt1.setNCharacterStream(1, new StringReader(testName), testName.length());
    ps.setNCharacterStream(2, new StringReader(testNumber), testNumber.length());
    ps.execute();