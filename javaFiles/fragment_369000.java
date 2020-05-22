public class TestMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(TestMessageListener.class);

    @Override
    public void onMessage(Message message) {

        /* Receive the text message */
        if (message instanceof TextMessage) {

            try {
                String text = ((TextMessage) message).getText();
                System.out.println("Message reception from the JMS queue : " + text);

            } catch (JMSException e) {
                logger.error("Error : " + e.getMessage());
            }

        } else {
            /* Handle non text message */
        }
    }
}