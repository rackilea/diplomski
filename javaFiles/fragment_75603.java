String mysql_jdb_driver = "com.mysql.jdbc.Driver";          // the connector for the database
String mysql_db_url = "jdbc:mysql://localhost/notas";       // url to connect, in this case is local but you can connect to an ip
String mysql_db_user = "root";                              // DB user name MYSQL
String mysql_pass = "";                                     //DB password

try{                                                                //try to connect to the DB
    Class.forName(mysql_jdb_driver).newInstance();
    conn = DriverManager.getConnection(mysql_db_url,mysql_db_user, mysql_pass );
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT ...");//put your select here
    stmt.executeUpdate("INSERT ...");//put insert, delete here

}
catch(Exception ex){                                
    ex.printStackTrace();
}
finally                                                              // always close the connecttion
{
    conn.close();           
}