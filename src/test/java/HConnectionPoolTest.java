import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import static org.junit.Assert.*;

public class HConnectionPoolTest {

    @Test
    public void should_parse_html() throws SQLException {
        final Connection connection = HConnectionPool.getConnection();
        final boolean autoCommit = connection.getAutoCommit();

    }

}