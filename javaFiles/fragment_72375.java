public void createTableStudent() 
{
    try {
        connection = (Connection) dbSource.getConnection();

        String qry = "SELECT studentName From batcha "; 
        System.out.println(qry);

        stmt = (PreparedStatement)  connection.prepareStatement(qry);
            rs =  stmt.executeQuery();

            while (rs.next()) 
            {

                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(DB_URL_table, USER, PASS);

                Statement newStmt = connection.createStatement();

                try {
                        String check=new String(rs.getString(("studentName")));
                        String student = check.replaceAll("\\s","");



                        String sql1 = "CREATE TABLE IF NOT EXISTS "+student+" " +
                            "(id INTEGER not NULL AUTO_INCREMENT, " +
                            " fcltyName VARCHAR(255), " + 

                            "CommunicationOral INTEGER, "+
                            "Communicationwritten INTEGER, "+
                            "Leadership INTEGER, "+
                            "AnalyticalAbilities INTEGER, "+
                            "Interpersonalskills INTEGER, "+
                            "DecisionMakingSkills INTEGER, "+
                            "SelfConfidence INTEGER, "+
                            "Creativity INTEGER, "+
                            "Punctualityregularity INTEGER, "+
                            "GeneralAwareness INTEGER, "+
                            "Commitment INTEGER, "+
                            "Hardwork INTEGER, "+

                            " PRIMARY KEY ( id ))"; 

                        newStmt.executeUpdate(sql1); 
                    }

                finally
                {
                    try 
                    {
                        if(newStmt!=null)
                            newStmt.close();
                    } 
                    catch (SQLException e) 
                    {
                        e.printStackTrace();
                    }
                }

            }



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally
    {
        try {
                if(rs!=null)
                    rs.close();
                if(stmt!=null)
                    stmt.close();
                if(connection!=null)
                    connection.close();                     
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}