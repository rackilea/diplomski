public class DBConnection {

public Connection conn=null;
private static DBConnection dbConn=null;
static final String DB_URL=
        "jdbc:sqlserver://10.0.0.47\\test;databaseName=a;";
static final String DB_USER="sa";
static final String DB_PASS="123";


 public Connection secCon=null;
static final String DB_URL_SECOND= // URL

static final String DB_USER_SECOND=""; // user name
static final String DB_PASS_SECOND="123";




public DBConnection(){
     if(conn==null){
         try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
             conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             secCon=DriverManager.getConnection(DB_URL_SECOND, DB_USER_SECOND, DB_PASS_SECOND);
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
     }
}