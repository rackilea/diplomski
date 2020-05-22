public class Foo {

    private final ConnectionProvider connectionProvider;

    private Foo(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public boolean ping(){
            boolean ping = false;
            Connection connection = null;
            try{
                connection = connectionProvider.getConnection();
                ping = true;
            }catch(Exception e){
                // TODO handle this exception
            }finally{
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO handle this exception
                }
            }
            return ping;
        }

}

public interface ConnectionProvider {

    Connection getConnection();
}

@org.junit.Test
public void testConnection() throws Exception {
    ConnectionProvider mockProvider = mock(ConnectionProvider.class);
    Connection mockConnection = mock(Connection.class);
    when(mockProvider.getConnection()).thenReturn(mockConnection);

    Foo foo = new Foo(mockProvider);

    assertTrue(foo.ping());

    verify(mockConnection).close();
}