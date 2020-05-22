class MessageCommandFactory {
       Command get(MessageType messageType) {
         if(messageType == MSG_1_TYPE) {
           return new Message1Command();
         } else ...
       } 

    class MessageListener {
    MessageCommandFactory messageCommandFactor;
        onMessage(My_Absctract_Message message) {
          Command command =  messageCommandFactory.get(message.getType());
          command.execute();
      }
   }