Connection connection;
    Statement statement;
    String driver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/demoDb";
    String login = "root";
    String password = "";
    try {
        Class.forName(driver);
        connection = DriverManager.getConnection(dbURL, login,password);
        statement = connection.createStatement();
    } catch (SQLException e) {
        connection = null;
        System.out.println("drivernot found");
        System.out.println("SQLException:" + e);
    } catch (Exception e) {
        System.out.println("Exception:" + e);
    }