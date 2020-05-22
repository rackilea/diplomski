static class MessageListener {
    private String triggerMessage;
    private MessageTriggerListener runnable;

    public interface MessageTriggerListener {
        public void onMessageReceived(String message);
    }

    MessageListener(String message, MessageTriggerListener runnable) {
        this.triggerMessage = message;
        this.runnable = runnable;
    }

    private void trigger(String message) {
        if (message.equals(triggerMessage)) {
            runnable.onMessageReceived(message);
        }
    }
}