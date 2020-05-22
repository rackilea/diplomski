Properties p= new Properties();
p.put("user", "admin");
p.put("password", "secret");
p.put("clientProgramName", "xxxx_application");
Connection conn = DriverManager.getConnection(
    "jdbc:db2://localhost:50000/yourdb", props);