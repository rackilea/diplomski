public class Database {
    private Connection connection = null;
    private Statement statement = null;
    private String serverName = null;
    private String dbName = null;
    private String  dbtablename = null;
    private String username = null;
    private String password = null;

   public Database() {
        serverName = //your value;
        dbName = your value
        dbtablename = //your value
        username = //your value
        password = //your value
    }

   public Connection OpenConnectionDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection("jdbc:mysql://" + serverName + "/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8&" + "user=" + username + "&password=" + password);
            System.out.println("conection: " + connection);
            //            this.connection = DriverManager.getConnection("jdbc:mysql://" + serverName + "/" + dbName  +"?user=" + username + "&password=" + password );
            //System.out.println("debug: Connect to dbServer");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public void closeConnectionDB() {
        if (this.connection != null) {
            try {
                connection.close();
                connection = null;
                //System.out.println("debug: Close dbServer");
            } catch (SQLException ex) {
                System.out.println("debug: Closing Database... FAILED (NOT RUNNING)");
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void insert(){
         String query = //your insert query
         OpenConnectionDB();
         try {
            this.statement = this.connection.createStatement();
                this.statement.execute(query);
                statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnectionDB();
    }

   public String getResults(){
        String query = //select query
        OpenConnectionDB();
        try {
            this.statement = this.connection.createStatement();
            ResultSet  rs = this.statement.executeQuery(query);

            if(rs!=null){
                while(rs.next()){
                    return rs.getString("Your_field_name_in_db"); //get your 
                }            
            }

             statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnectionDB();
        return null;
    }


}