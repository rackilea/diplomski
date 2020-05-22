public class FakeMessageProcessor implements IMessageProcessor
{
    public void processMessage(Message m)
    {
        System.out.println("Using FakeMessageProcessor to process message " + m);
    }
}