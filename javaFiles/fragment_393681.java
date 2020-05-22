DataSource ds = new BasicDataSource();
ds.setUsername( getInput() );
// ... set all parameters needed
JournalPersistenceAdapterFactory factory = new JournalPersistenceAdapterFactory();
factory.setDataDirectoryFile(data);
//.. set all parameters needed
BrokerService broker = new BrokerService();
broker.setPersistenceFactory(factory);
broker.addConnector(ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
// More config goes here
broker.start();