import java.sql.*; 

public class Conection{

    public static void main(String a[]) throws ClassNotFoundException, SQLException
{
    try
    {
       /// String url = "jdbc:sqlserver://localhost\\MALIKUSMANNAWAZ:1433;databaseName=ali";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MALIKUSMANNAWAZ:1433;databaseName=ali","sa","dbase");
        System.out.println("connection created");
        Statement st=conn.createStatement();
        String sql="select * from Login_System";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            System.out.println("Name: "+rs.getString(1));



            }
            if(st!=null)
            st.close();
            if(conn!=null)
                conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("Sql exception "+sqle);
        }
    }
}