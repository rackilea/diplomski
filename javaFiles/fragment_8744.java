@JmsListener
public void processOrder(Message message) throws JMSException {
     String convertedMessage = ((TextMessage) message).getText();
     :
     :
}