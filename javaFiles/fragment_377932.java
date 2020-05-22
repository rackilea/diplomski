class MyQueueReceiver implements javax.jms.MessageListener {

    QueueReceiver queueReceiver = queueSession.createReceiver(myQueue);
    queueReceiver.setMessageListener(this);
    ...
    public void onMessage(Message msg){
      //consume message here
    }
}