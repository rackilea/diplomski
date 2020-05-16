import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class HConnectionPoolTest {

    @Test
    public void should_parse_html() throws SQLException {
        final Connection connection = HConnectionPool.getConnection();
        final boolean autoCommit = connection.getAutoCommit();

    }

}