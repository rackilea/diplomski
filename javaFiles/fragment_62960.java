class MessageHandler
{
    private IMessageProcessor processor;
    private IMessageValidator validator;

    public MessageHandler(IMessageProcessor processor)
    {
        this.processor = processor;

        //Use the given processor as validator, if it implements the IMessageValidator-interface
        if(IMessageValidator.class.isAssignableFrom(processor.getClass()))
        {
            this.validator = (IMessageValidator)processor;
        }   
    }

    public void setMessageValidator(IMessageValidator validator)
    {
        this.validator = validator;
    }

    public void handleMessage(Message message)
    {
        validateMessage(message);
        processor.processMessage(message);
        System.out.println("Message " + message + " handled by MessageHandler");
    }

    protected void validateMessage(Message message)
    {
        if(validator != null)
        {
            validator.validateMessage(message);
        }
        else
        {
            System.out.println("No IMessageValidator-implementation set, using default validation for message " + message);
        }
    }
}