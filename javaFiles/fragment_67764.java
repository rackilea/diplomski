public void setupListening()
{        
    try{
    PushRegistry.registerConnection("cbs://:50",this.getClass().getName(),"*");
    }catch(Exception e){}
    String[] connList;
    connList = PushRegistry.listConnections(true);
if((connList == null) || (connList.length == 0))
{
  // You can exit the app, if you want
}
else 
    { 
    try{
    msgconn = (MessageConnection)Connector.open("cbs://:50");
        msgconn.setMessageListener(this);
    } catch( IOException e){ e.printStackTrace();}
     }
}