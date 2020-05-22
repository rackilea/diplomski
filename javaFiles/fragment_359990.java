import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class TestDatabase2 {
  public static void main(String args[]){
    try{
      Class.forName("oracle.jdbc.OracleDriver");

      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","username","password");

      // Convert your lists to arrays using #toArray( T[] )

      String[] l1 = { "Math", "Physics" };
      String[] l2 = { "English", "Spanish" };
      String[] l3 = { "French", "German" };

      ARRAY school = new ARRAY( des, con, newString[][][]{
        new String[][]{ l1, l3 },
        new String[][]{ l2, l3 }
      } );

      ArrayDescriptor des = ArrayDescriptor.createDescriptor("STRINGLIST_LIST_LIST", con);

      CallableStatement st = con.prepareCall("{ call add_school( :school )}");

      // Passing an array to the procedure - 
      ((OracleCallableStatement) st).setARRAYAtName( "school", school );

      st.execute();
    } catch(ClassNotFoundException | SQLException e) {
      System.out.println(e);
    }
  }
}