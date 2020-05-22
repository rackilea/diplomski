public int checkBetweenDates() throws SQLException{
        String t1 = "2015-07-08"; //or later some user input variable
        String t2 = "2015-07-09";//or later some user input variable
        String id = "22 03 E7 99";//or later some user input variable
        int rowCount = -1;
        //Statement stmt = null;        

        String dateChoice = "select count(*) " 
                + "from dancers " 
                + "where ts between ? and ?"
                + "AND id = ?";

        Connection conn = DriverManager.getConnection(host, username, password);
        System.out.println("Connected:");
         PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(dateChoice);
       preparedStmt.setString    (1, t1);
       preparedStmt.setString    (2, t2);
       preparedStmt.setString    (3, id);
        // stmt = conn.createStatement();
        ResultSet rs = preparedStmt.executeQuery(dateChoice); 
        try {
                rs = preparedStmt.executeQuery(dateChoice);
                rs.next();
                rowCount = rs.getInt(1);
                System.out.println(rowCount);
            }
         catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            rs.close();
            preparedStmt.close();
        }
        return rowCount; 

    }