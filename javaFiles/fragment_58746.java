public class Chat {

    private Map<String, Boolean> messageKeys;

    public Chat() {
        // Default constructor required for calls to DataSnapshot.getValue(Chat.class)
    }

    public Chat(Map<String, Boolean> messageKeys) {
        this.messageKeys = messageKeys;
    }

    public Map<String, Boolean> getMessageKeys() {
        return messageKeys;
    }

    public void setMessageKeys(Map<String, Boolean> messageKeys) {
        this.messageKeys = messageKeys;
    }
}