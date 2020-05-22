public void onMessage(Message msg)
{
    TextMessage tm = (TextMessage) msg;
    long now = System.currentTimeMillis();
    long responseTime = 0;
    synchronized(timemap){
         Long sent = timemap.get(msg.getJMSCorrelationID());
         if(sent != null){
             /* Store this value, this is the response time in milliseconds */
             responseTime = now - sent; 
         }else{
             /* Error condition. */
         }
    }

}