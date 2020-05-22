if(connection == null || connection.isClosed()) {
        try {
            connection = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL","usr","pass");
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    return connection;