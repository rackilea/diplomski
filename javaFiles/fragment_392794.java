public String RegisterUser(... ) {
    boolean trovato = false;
    int authorized=0;

    SqliteConnection sqlite = new SqliteConnection();
    String dbPath="C:/Users/l.pellegrini/eclipse-workspace/ClayAPI_dbembedded/claydb.db";
    String query="SELECT Username,Password FROM Apps WHERE Username ='"+username+"' and Password='"+password+"'";

    try (java.sql.Connection con = sqlite.connect();
         Statement statement = con.createStatement();
         Statement updStatement = con.createStatement();
         ) {
        ResultSet rsActiveServices = con.createStatement().executeQuery(query);
        // handle result set as before
    } catch(SQLException e) {
        e.printStackTrace();
        System.out.println("errore" + e);
    }
    if(trovato==false) {
        createUser(username, password, name, surname, appname, email, ip)
    }
    return "username: " + username;
}


private createUser(String username, String password, String name, String surname, String appname, String email, String ip {
    String query1="INSERT INTO Apps (Username,Password,Name,Surname,Email,AppName,Ip,Authorized,Token) VALUES ('" + username + "'," + "'" +password +"','" + name + "','" + surname + "','" +email + "','" + appname + "','"+ip+"','"+authorized+"','"+token+"')";         
    SqliteConnection sqlite = new SqliteConnection();
    String dbPath="C:/Users/l.pellegrini/eclipse-workspace/ClayAPI_dbembedded/claydb.db";

    try (java.sql.Connection con = sqlite.connect();
         Statement statement = con.createStatement();) {
        updStatement.executeUpdate(query1);
    } catch(SQLException e) {
        e.printStackTrace();
        System.out.println("errore" + e);
    }
}