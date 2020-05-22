public static String connectDB(String configFile, String query) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
    Properties p = new Properties();
    p.load(new FileInputStream(configFile));

    String serverName = (p.getProperty("RMS_DBServerName"));
    String portNumber = (p.getProperty("DB_PortNumber"));
    String sid = (p.getProperty("RMS_SID"));
    String url = "jdbc:oracle:thin:@//" + serverName + ":" + portNumber + "/" + sid;
    String username = (p.getProperty("RMS_Username"));
    String password = (p.getProperty("RMS_Password"));

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection connection = DriverManager.getConnection(url,username,password);
    String setr = null;
    try {      
        Statement stmt = connection.createStatement();

        try {ResultSet rset = stmt.executeQuery(query);
            try {
                while(rset.next())   
                    setr = rset.getString(1);
                    return setr;  
            }        
            finally {
                try { rset.close(); 
                } 
                catch (Exception ignore) {}

            }
        } 
        finally {
            try { stmt.close(); 
            } 
            catch (Exception ignore) {}
        }
    } 
    finally {
        try { connection.close(); 
        } 
        catch (Exception ignore) {}

    }
}