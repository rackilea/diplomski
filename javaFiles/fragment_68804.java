import static org.easymock.EasyMock.expect;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DriverManager.class, H2Persistence.class})
public class H2PersistenceTest {
    @Test
    public void testDropPersonIsCalled() throws SQLException {
        final Statement statement = mock(Statement.class);

        final Connection connection = mock(Connection.class);

        when(connection.createStatement()).thenReturn(statement);

        mockStatic(DriverManager.class);

        expect(DriverManager.getConnection(H2Persistence.CONN_TYPE_USER_HOME))
                .andReturn(connection);
        expect(DriverManager.getConnection(null))
                .andReturn(null);

        replay(DriverManager.class);
        final H2Persistence objectUnderTest = new H2Persistence();

        objectUnderTest.open();

        verify(statement).executeUpdate("DROP TABLE IF EXISTS PERSON");
        verify(statement).executeUpdate(H2Persistence.CREATE_TABLE_PERSON);
    }
}