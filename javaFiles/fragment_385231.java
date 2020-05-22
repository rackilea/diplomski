public class Notifier {
    public static void main(String[] args) throws Exception {
        // Start a thread for each JMQ queue to monitor.
        DestinationThread destination1 = new DestinationThread("queue1");
        DestinationThread destination2 = new DestinationThread("queue2");
        destination1.start();
        destination2.start();
    }
}