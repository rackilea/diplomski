public class FakeMessageValidator implements IMessageValidator
{
    public void validateMessage(Message m)
    {
        System.out.println("Using FakeMessageValidator to validate message " + m);      
    }
}