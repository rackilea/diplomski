public class MessageTest
{   
    public static void main(String[] args)
    {
        //Using processor implementing only IMessageProcessor, MessageHandler will use default validation
        IMessageProcessor processor = new FakeMessageProcessor();
        MessageHandler handler = new MessageHandler(processor);

        handler.handleMessage(new Message(1));

        //Setting separate validator to existing MessageHandler-instance
        handler.setMessageValidator(new FakeMessageValidator());

        handler.handleMessage(new Message(2));

        //Using processor implementing both IMessageProcessor and IMessageValidator
        processor = new FakeMessageProcessorAndValidator();
        handler = new MessageHandler(processor);

        handler.handleMessage(new Message(3));
    }
}