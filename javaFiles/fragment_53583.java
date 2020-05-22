public Message[] getMessages() throws Exception {

  try{
      //Connection to mail server, getting all messages and putting them to an array
      return Message[];
  } finally {
      CloseConnectionToMailServer(); //I don't need it anymore, I just need messages
  }

  return null;
}