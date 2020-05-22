public class AQMessageListenerContainer extends DefaultMessageListenerContainer {

    @Override
    protected MessageConsumer createConsumer(Session session, Destination destination) throws JMSException {
        return ((AQjmsSession) session).createConsumer(destination, getMessageSelector(),
                OracleAQObjORADataFactory.getORADataFactory(), null, isPubSubNoLocal());
    }
}