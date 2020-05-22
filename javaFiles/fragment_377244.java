String dbURL = "jdbc:jtds:sqlserver://DataBase Name";
    String user = "username";
    String pass = "password";

    try {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, user, pass);
        JDBCTest jt = new JDBCTest();

        String sql = "update Table1 " + "set DBID = DBID+1 where TABLENAME = '" + "Table2'" +"\n"+ 
                "select DBID from Table1 where TABLENAME = '" + "Table2" + "'";
        System.out.println("generateId(), SQL = " + sql);
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        int id = -1;
        System.out.println("Result set :->"+rs);
        while(rs.next()) {
            id = rs.getInt(1);
            System.out.println("id is :-> "+ id);
        }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }