final Properties props = new Properties();
props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
props.setProperty(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
props.setProperty(Context.SECURITY_PRINCIPAL, "user"); // add an application user before
props.setProperty(Context.SECURITY_CREDENTIALS, "user1234");

final InitialContext ic = new InitialContext(props);

final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
System.out.println(factory != null ? "Factory is not null" : "Factory is null");