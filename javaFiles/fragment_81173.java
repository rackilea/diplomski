public class Client {
    void messageReceived(IMessage message) {
        switch (message.getMessageType()) {
        case TYPE_A:
           // process type A
           break;
        case TYPE_B:
           ...
        }
    }
}