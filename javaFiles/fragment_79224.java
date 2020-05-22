try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DriverManager.getConnection("jdbc:sqlserver://url.com;database=dbname;user=username;password=test")
    } catch (SQLException e) {
        e.printStackTrace();
    }
catch (ClassNotFoundException e) {
        e.printStackTrace();
    }