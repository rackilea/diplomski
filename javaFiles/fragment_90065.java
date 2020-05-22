SQL> CREATE OR REPLACE
  2  AND COMPILE JAVA SOURCE NAMED "ArrayDemo"
  3  as
  4  import java.io.*;
  5  import java.sql.*;
  6  import oracle.sql.*;
  7  import oracle.jdbc.driver.*;
  8  
  9  public class ArrayDemo {
 10  
 11     public static void passArray() throws SQLException {
 12  
 13        Connection conn =
 14           new OracleDriver().defaultConnection();
 15  
 16  
 17        StructDescriptor itemDescriptor =
 18           StructDescriptor.createDescriptor("IDS",conn);
 19  
 20        Object[] itemAtributes = new Object[] {new Integer(1),
 21                                               new Integer(2),
 22                                               new Integer(3)};
 23        STRUCT itemObject1 = new STRUCT(itemDescriptor,conn,itemAtributes);
 24  
 25        itemAtributes = new Object[] {new Integer(4),
 26                                      new Integer(5),
 27                                      new Integer(6)};
 28        STRUCT itemObject2 = new STRUCT(itemDescriptor,conn,itemAtributes);
 29  
 30        STRUCT[] idsArray = {itemObject1,itemObject2};
 31  
 32        ArrayDescriptor descriptor =
 33           ArrayDescriptor.createDescriptor( "IDS_TABLE", conn );
 34  
 35        ARRAY array_to_pass =
 36           new ARRAY( descriptor, conn, idsArray );
 37  
 38        OraclePreparedStatement ps =
 39           (OraclePreparedStatement)conn.prepareStatement
 40           ( "begin getInfo(:x); end;" );
 41  
 42        ps.setARRAY( 1, array_to_pass );
 43        ps.execute();
 44  
 45     }
 46  }
 47  /
Java created