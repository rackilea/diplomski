public class FakeMessageProcessorAndValidator implements IValidatingMessageProcessor
{
    public void validateMessage(Message m)
    {
        System.out.println("Using FakeMessageProcessorAndValidator for validating message " + m);
    }

    public void processMessage(Message m)
    {
        System.out.println("Using FakeMessageProcessorAndValidator for processing message " + m);       
    }
}