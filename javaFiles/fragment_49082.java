public class MyConsumer implements ExceptionListener, MessageListener {

    private void init(){
        Connection connection = ... //create connection
        connection.setExceptionListener(this);
        connection.start();
    }

    public void onException(JMSException e){
        String errorCode = e.getErrorCode();
        Exception ex = e.getLinkedException();
        //clean up resources, or, attempt to reconnect 
    }

    public void onMessage(Message m){
       ...
}