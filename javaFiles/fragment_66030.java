import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class Test {


    @org.junit.Test
    public void test() throws SQLException {

        // prepare the dependant mock
        ResultSetMetaData rsMetaMock = Mockito.mock(ResultSetMetaData.class);
        when(rsMetaMock.getColumnName(eq(1))).thenReturn("something");

        // prepare main mock for result set and define when 
        // main mock to return dependant mock
        ResultSet rs = Mockito.mock(ResultSet.class);
        when(rs.getMetaData()).thenReturn(rsMetaMock);

        // application logic
        ResultSetMetaData rsmd = rs.getMetaData();

        //assertions
        assertEquals(rsmd.getColumnName(1), "something");
    }
}