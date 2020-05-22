import java.sql.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;

public class JavaRefCursorTest {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "user", "password");

        try (CallableStatement cstmt1 = conn.prepareCall(
                "{ call java_ref_curs_test.get_ref_cursor(?)}")) {
            cstmt1.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt1.execute();

            try (ResultSet rSet = (ResultSet)cstmt1.getObject(1)) {
                try (CallableStatement cstmt2 = conn.prepareCall(
                        "{ call java_ref_curs_test.print_refcursor(?)}")) {

                    // Uncomment the next line to call setCursor:
                    // ((OracleCallableStatement)cstmt2).setCursor(1, rSet); 

                    // Uncomment the next line to call setObject:
                    // cstmt2.setObject(1, rSet);

                    cstmt2.execute();
                }
            }
        }
    }
}