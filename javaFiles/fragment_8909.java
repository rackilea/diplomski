Connection connection = null;
    Statement statement = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/",
                "root", "admin");
        statement = connection.createStatement();
        String sql = "CREATE DATABASE DBNAME";
        //To delete database: sql = "DROP DATABASE DBNAME";
        statement.executeUpdate(sql);
        System.out.println("Database created!");
    } catch (SQLException sqlException) {
        if (sqlException.getErrorCode() == 1007) {
            // Database already exists error
            System.out.println(sqlException.getMessage());
        } else {
            // Some other problems, e.g. Server down, no permission, etc
            sqlException.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        // No driver class found!
    }
    // close statement & connection