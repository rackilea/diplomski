@JmsListener(destination = "dest", containerFactory = "cf")
public void processMessage(TextMessage message) throws JMSException {
    //do the actual processing
    actualProcessing(message);
    //if there's countDownLatch call the countdown.
    if(countDownLatch != null) {
        countDownLatch.countDown();
    }
}