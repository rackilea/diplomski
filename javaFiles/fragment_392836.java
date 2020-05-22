@Stateless
public class SendEventsBean {

  private static final Logger log = Logger.getLogger(SendEventsBean.class);

  @Resource(mappedName = "jms/MyConnectionFactory")
  private ConnectionFactory jmsConnectionFactory;

  @Resource(mappedName = "jms/myApp/MyQueue")
  private Queue queue;

  public void sendEvent() {
    Connection jmsConnection = null;
    try {
        connection = jmsConnectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        MyObj obj = new MyObj(1, "Foo");
        ObjectMessage myObjMsg = session.createObjectMessage(obj);
        producer.send(myObjMsg);
    } catch (JMSException jmxEx) {
        log.error("Couldn't send JMS message: ", jmsEx);
    }finally{
        if (jmsConnection != null) {
            try {
                jmsConnection.close();
            }catch(JMSException ex) {
               log.warn("Couldn't close JMSConnection: ", ex);
            }
        }
    }
  }

}