public class RPCMessage implements Serializable {
    //public static final short REQUEST = 0; // Not required
    //public static final short REPLY = 1; // Not required

    public enum MessageType {
        REQUEST((short)0),

        REPLY((short)1);

        private short enumVar;

        private MessageType(short var){
            enumVar = var;
        }
    };


    private MessageType messageType;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }


}