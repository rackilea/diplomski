// Step 1. Create the Configuration, and set the properties accordingly
     Configuration configuration = new ConfigurationImpl();
     configuration.setPersistenceEnabled(false);
     configuration.setSecurityEnabled(false);
     configuration.getAcceptorConfigurations().add(new TransportConfiguration(InVMAcceptorFactory.class.getName()));

     // Step 2. Create and start the server
     HornetQServer server = HornetQServers.newHornetQServer(configuration);
     server.start();

     // Step 3. As we are not using a JNDI environment we instantiate the objects directly
     ClientSessionFactory sf = HornetQClient.createClientSessionFactory(new TransportConfiguration(InVMConnectorFactory.class.getName()));

     // Step 4. Create a core queue
     ClientSession coreSession = sf.createSession(false, false, false);