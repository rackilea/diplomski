public void notifyIncomingMessage(MessageConnection conn)
{
  try{
        txtmsg =(TextMessage)msgconn.receive();
     }catch(Exception e){System.out.println(e);}
     from = txtmsg.getAddress());
     Msg = txtmsg.getPayloadText();
    // Display from & Msg            
}