if (con == null){
        try {
            con = DriverManager.getConnection(dbname,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (statement == null){
        try {
            statement= con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }`