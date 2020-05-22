try {
        //  con = dbConn.mySqlConnection();
            con = DatabaseConnection.getRAWConnection();
 String insertSqlTable = "insert into certification VALUES(?,?,?,?,?,?,?,?)";
        pst = con.prepareStatement(insertSqlTable);
        pst.setInt(1, td.getEmpId());
        pst.setString(2, td.getRname());
        pst.setString(3, td.getStream());
        pst.setString(4, td.getCertificationType());
        pst.setString(5, td.getCertificationName());
        pst.setString(6, td.getCertificationDate());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        pst.setTimestamp(7, date);
        pst.setInt(8, td.getScore());

        int count = pst.executeUpdate();
        if (count >= 1) {
            con.commit();
            status = true;
        } else {
            System.out.println("Error occured while inserting certification details into database");
            con.rollback();
            status = false;
        }

}