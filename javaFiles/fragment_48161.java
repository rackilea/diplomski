public static MessageFactory getMessageFactoryFromId(int uuid){
 switch (uuid) {
  case FIRST_MESSAGE_ID:
    return new FirstMessageFactory();
    ...
  default:
      // Error
      return null;
  }
}