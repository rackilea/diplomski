public class ConnectionFactoryProvider {
    public static IConnectionFactory getConnectionFactory(IConnectionFactory connectionFactory) {
    //use the connectionFactory
    }
}

//unit test
ConnectionFactoryProvider cfp = new ConnectionFactoryProvider(aMockConnectionFactoryInstance);

//live code
ConnectionFactoryProvider cfp = new ConnectionFactoryProvider(aDefaultConnectionFactoryInstance);