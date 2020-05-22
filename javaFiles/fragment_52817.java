Connection conn = null;
    CallableStatement callableStatement = null;
    ResultSet rs = null;

    try {
        conn = getconn();
        callableStatement = conn.prepareCall("{call proc_search(?, ?)}");    
        callableStatement.setString(1, login);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

        callableStatement.executeUpdate();    

        rs = (ResultSet) callableStatement.getObject(2);    
        while (rs.next()) {
            String userid = rs.getString("name");
        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());
        e.printStackTrace();

    } finally {

        if (rs != null) {
            rs.close();
        }

        if (callableStatement != null) {
            callableStatement.close();
        }

        if (conn != null) {
            conn.close();
        }

    }

    }