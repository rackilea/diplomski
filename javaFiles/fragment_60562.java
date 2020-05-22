public void onMessage(Message message){
  try{
    TextMessage msg = (TextMessage)message;
    fileOutput.write( msg.getText());
    fileOutput.flush();

  }catch(Exception e){
    e.printStackTrace();
    throw e;
  }
}