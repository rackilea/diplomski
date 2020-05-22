public interface MessageListener {
    public void notify(Message msg);
}

public class MainWindow implements MessageListener {
    public void notify(Message msg) {
        // UI Action
    }
}

public class Client {
    private MessageListener listener;

    public void setMessageListener(MessageListener listener) {
        this.listener = listener;
    }
}