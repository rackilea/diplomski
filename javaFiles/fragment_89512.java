public interface Message {
     void process();
     //some other methods
}

public class MessageType1  implements Message {
    @Override
    public void process() {
      //My special way to process this message
}
}