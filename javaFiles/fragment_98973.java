package yourPackage;
import java.sql.*;
import java.util.*;

public class className
    {
    String mySqlPassword="root";
    String mySqlUsername="root";
    String mySqlDatabase="jdbc:mysql://localhost:3306/yourDatabse";


ResultSet res;



    public String myRequiredMethod(String result)
        {

        String success="";
        try
            {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(mySqlDatabase,mySqlUsername,mySqlPassword);

                String q="insert into myTable (resultColumn) values('" + result + "')";
            System.out.println(q);
            PreparedStatement stmt = con.prepareStatement(q);
            int pos = stmt.executeUpdate();
            System.out.println(pos);
        if(pos==1)
                {
                    success="Successfull";
                }
            } 

        catch(Exception e)
            {
        }

        return success;

        }
}