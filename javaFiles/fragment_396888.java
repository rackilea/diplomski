@Component
public class MessageListener {

    @JmsListener(destination = "my.queue")
    public void receiveMessage(String msg) {
        System.out.println("Received :" + msg);
    }
}