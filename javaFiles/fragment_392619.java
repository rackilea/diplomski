ps = con.prepareStatement(yourSqlHere);
        // optional parameters setting
        ps.setXXX(1, val);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("NODE_TYPE") + ": " + rs.getInt("TOTAL"));
        }