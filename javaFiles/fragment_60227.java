Properties connectionProps = new Properties();
connectionProps.put("user", "root");
connectionProps.put("password", "");

String url ="jdbc:mysql://localhost/main";

Connection conn = DriverManager.getConnection(url, connectionProps);