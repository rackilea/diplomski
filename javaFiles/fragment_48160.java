public interface MessageFactory {
   Message createMessage(Map<String, Object> fields);
   Message createMessage(ByteBuffer buffer);
}

public class FirstMessageFactory implements MessageFactory {
  public Message createMessage(Map<String, Object> fields){
    return new FirstMessage(fields);
  }

  public Message createMessage(ByteBuffer buffer){
    return new FirstMessage(buffer);
  }

}