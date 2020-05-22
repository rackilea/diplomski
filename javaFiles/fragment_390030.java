import java.sql.*;
import java.util.*;

public class JDBCStructs {
    public static void main(String[] args) throws Exception {
        Connection c = ...

        Map<String, Class<?>> map = c.getTypeMap();
        map.put("ELEM", Elem.class);
        c.setTypeMap(map);        

        CallableStatement cs = c.prepareCall("{call work(?, ?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
        cs.execute();
        String a = cs.getString(1);
        System.out.println("Got string " + a);
        ResultSet rSet = (ResultSet)cs.getObject(2);
        while (rSet.next()) {
            String col1 = rSet.getString(1);
            String col2 = rSet.getString(2);
            Array list = (Array)rSet.getObject(3);
            System.out.println("Got " + col1 + ", " + col2 + " and " + Arrays.toString((Object[])list.getArray()));
        }
    }
}