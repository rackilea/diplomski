public class ReceivedDataHolder{
    BlockingQueue<Object> dataBuffer = new LinkedBlockingQueue<Object>();
    //...
    public void dataReceived(Object data){
       dataBuffer.offer(data);
    } 

    public Object getReceivedData(){
       return dataBuffer.take();
    }
}