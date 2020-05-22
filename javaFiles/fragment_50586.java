Hashtable<String, String> env = new Hashtable<>();
env.put(Context.INITIAL_CONTEXT_FACTORY,
               "org.apache.qpid.amqp_1_0.jms.jndi.PropertiesFileInitialContextFactory");
env.put(Context.PROVIDER_URL, 
    getClass().getResource("/application.properties").toString());
Context context = null;

context = new InitialContext(env);
// Look up ConnectionFactory 
ConnectionFactory cf = (ConnectionFactory) context.lookup("SBCF");
Destination queue = (Destination) context.lookup("EventHub");

// Create Connection
Connection connection = cf.createConnection();

// Create receiver-side Session, MessageConsumer
Session receiveSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
MessageConsumer receiver = receiveSession.createConsumer(queue);