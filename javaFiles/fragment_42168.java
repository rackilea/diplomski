public class PoolConnectionFactory extends BasePoolableObjectFactory<Connection> { 

    private final ConnectionFactory factory;
    public PoolConnectionFactory() {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
    }

    // for makeObject we'll simply return a new Connection
    public Connection makeObject() { 
        return factory.newConnection();
    } 

    // when an object is returned to the pool,  
    // we'll clear it out 
    public void passivateObject(Connection con) { 
        con.I_don't_know_what_to_do(); 
    } 

    // for all other methods, the no-op  
    // implementation in BasePoolableObjectFactory 
    // will suffice 
}