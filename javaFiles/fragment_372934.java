public class Receiver implements MessageListener {

    PrintWriter pw = new PrintWriter("result.log");
    Connection conn;
    Session sess;
    MessageConsumer consumer;

    public Receiver() throws Exception {


        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        MessageConsumer consumer = sess.createConsumer(sess.createTopic("logTopic"));
        consumer.setMessageListener(this);
    }

    public static void main(String[] args) throws Exception {
        new Receiver();

    }

    public void onMessage(Message message) {
        try {
            LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message).getObject();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS"); 
            String nowAsString = df.format(new Date(event.getTimeStamp())); 

            pw.println("["+ nowAsString + "]" + 
                    " [" + event.getThreadName()+"]" +
                    " ["+ event.getLoggerName() + "]" +
                    " ["+ event.getMessage()+"]");
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}