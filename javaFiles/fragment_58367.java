import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.jboss.jca.adapters.jdbc.WrappedConnection;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.SqlValue;

import oracle.jdbc.pool.OracleDataSource;

public class SimpleDbStandaloneTest extends StoredProcedure {

    public SimpleDbStandaloneTest(DataSource ds, String sp) {

        super(ds, sp);
        declareParameter(new SqlInOutParameter("io_col", Types.CLOB, null, new SqlReturnType() {

            @Override
            public Object getTypeValue(CallableStatement cs, int paramIndex, int sqlType, String typeName)
                    throws SQLException {

                //not all methods work for both CLOB and Clob but at least getCharacterStream() does
                java.sql.Clob clob = (java.sql.Clob) cs.getObject(paramIndex,java.sql.Clob.class);

//              oracle.sql.CLOB clob = (oracle.sql.CLOB) cs.getObject(paramIndex,oracle.sql.CLOB.class);

                System.out.println(clob); //just checking, the jdbc driver returns the deprecated CLOB class

                Reader r = clob.getCharacterStream();
                char[] cbuf = new char[1];
                try {
                    r.read(cbuf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new String(cbuf);
            }

        }));
        compile();
    }


    public Map<String, Object> execute() {

        Map<String, Object> inputs = new HashMap<>();
        Connection conn = null;
        WrappedConnection wc = null;

        try {

            conn = getJdbcTemplate().getDataSource().getConnection();

            if (conn instanceof WrappedConnection) {

                // this runs when the app is running from inside jboss
                wc = (WrappedConnection) conn;

            } else {

            }

            inputs.put("io_col",new SqlValue() {

                @Override
                public void setValue(PreparedStatement ps, int paramIndex) throws SQLException {

                    Reader r = new StringReader("z");
                    ps.setClob(paramIndex, r);

                }

                @Override
                public void cleanup() {

                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /* Close the connections manually to prevent connection leak */
            try {
                if (wc != null && !wc.isClosed())
                    wc.close();
            } catch (SQLException e) {
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
            }
            /* Close the connections manually to prevent connection leak */
        }

        Map<String, Object> outMap = execute(inputs);
        return outMap;
    }

    public static void main(String[] args) throws SQLException {

        OracleDataSource ods = getDataSource();

        SimpleDbStandaloneTest t = new SimpleDbStandaloneTest(ods, "TESTLEOSP");

        Map<String, Object> map = t.execute();

        System.out.println(map);
    }


    private static OracleDataSource getDataSource() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        (...)
        return ods;
    }

}