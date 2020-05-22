import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

public class PassStructToProcedure
{

  public static void main( final String[] args ){
    OracleConnection con = null;
    try{
      Class.forName( "oracle.jdbc.OracleDriver" );

      con = (OracleConnection) DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:orcl",
          "USERNAME",
          "PASSWORD"
      );

      BoundsSQL bound1 = new BoundsSQL( 2019, 1, 1, 0, 0, 0, 10, 1 );
      BoundsSQL bound2 = new BoundsSQL( 2019, 1, 1, 0, 0, 5, 10, 2 );

      OracleCallableStatement st = (OracleCallableStatement) con.prepareCall(
          "{ call MERGE_TIME_BOUNDS( ?, ?, ? ) }"
      );

      st.setObject( 1, bound1 );
      st.setObject( 2, bound2 );
      st.registerOutParameter( 3, OracleTypes.STRUCT, BoundsSQL.SQL_TYPE );
      st.execute();

      Map<String,Class<?>> typeMap = con.getTypeMap();
      typeMap.put( BoundsSQL.SQL_TYPE, BoundsSQL.class );

      BoundsSQL out = (BoundsSQL) st.getObject( 3 );

      System.out.println( out.toString() );

      st.close();
    } catch (ClassNotFoundException | SQLException ex) {
      System.out.println( ex.getMessage() );
      ex.printStackTrace();
    } finally {
      try{
        if ( con != null )
          con.close();
      }
      catch( SQLException e )
      {

      }
    }
  }
}