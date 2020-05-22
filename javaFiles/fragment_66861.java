public static void main(String[] args)  {
  Receiver receiverPlayer = null;
  try{
       // Instantiates Initiator
          Initiator initiatorPlayer = new Initiator();
       // Instantiates Receiver
          receiverPlayer = new Receiver();
       // start sending message
         initiatorPlayer.sendMessage(receiverPlayer); 
     }
  finally{
       if (receiverPlayer != null){
          receiverPlayer.dispose(); 
       }
  }
}