BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();

Task<Void> task = new Task<Void>() {
    @Override
    public Void call() throws Exception {
        final int numMessages = 300 ;
        Platform.runLater(() -> new MessageConsumer(messageQueue, ta_Statusbereich, numMessages).start());
        for (int i = 1; i <= numMessages; i++) {
            // do real work...
            messageQueue.put(Integer.toString(i));
        }
        return null ;
    }
};
new Thread(task).start(); // or submit to an executor...

// ...

public class MessageConsumer extends AnimationTimer {
    private final BlockingQueue<String> messageQueue ;
    private final TextArea textArea ;
    private final numMessages ;
    private int messagesReceived = 0 ;
    public MessageConsumer(BlockingQueue<String> messageQueue, TextArea textArea, int numMessages) {
        this.messageQueue = messageQueue ;
        this.textArea = textArea ;
        this.numMessages = numMessages ;
    }
    @Override
    public void handle(long now) {
        List<String> messages = new ArrayList<>();
        messagesReceived += messageQueue.drainTo(messages);
        messages.forEach(msg -> textArea.appendText("\n"+msg));
        if (messagesReceived >= numMessages) {
            stop();
        }
    }
}