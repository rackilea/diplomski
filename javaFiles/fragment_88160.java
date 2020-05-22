import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class PassTableOfObject {

      public static void main(String[] args) throws SQLException {
         Connection conn=FucntionTest.getConnection();

            try{

                StructDescriptor itemDescriptor = StructDescriptor
                        .createDescriptor("GROUP_OBJ", conn);

                STRUCT[] structs = new STRUCT[2];
                for (int index = 0; index < 2; index++)
                {

                    String[] params = new String[2];
                    params[0] = "Group "+index;
                    params[1] = "Param  1 "+index;
                    STRUCT struct = new STRUCT(itemDescriptor, conn, params);
                    structs[index] = struct;
                }

                ArrayDescriptor desc = ArrayDescriptor.createDescriptor("GROUP_TABLE", conn);
                ARRAY oracleArray = new ARRAY(desc, conn, structs);



                CallableStatement cs = null;
                cs = conn.prepareCall("{call GROUP_TABLE_TEST(?)}");
                cs.setArray(1, oracleArray);
                cs.execute();
                conn.commit();


                System.out.println("insert procedure executed successfully");                  

                }catch(SQLException e){
                    e.printStackTrace();        
                }finally{
                    conn.close();
                }
      }
}