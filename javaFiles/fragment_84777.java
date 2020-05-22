import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class GetRefCursorFromFunction
{
  public static void main( final String[] args ){
    try{
      Class.forName( "oracle.jdbc.OracleDriver" );

      Connection con = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:orcl",
          "USERNAME",
          "PASSWORD"
      );

      OracleCallableStatement st =
        (OracleCallableStatement) con.prepareCall( "BEGIN :1 := get_Ref_Cursor(); END;" );
      st.registerOutParameter( 1, OracleTypes.CURSOR );
      System.out.println( st.execute() );
      ResultSet rs = st.getCursor( 1 );
      while ( rs.next() )
      {
        System.out.println( rs.getInt( 1 ) );
      }

      st.close();
      con.close();
    } catch (ClassNotFoundException | SQLException ex) {
      System.out.println( ex.getMessage() );
      ex.printStackTrace();
    }
  }
}