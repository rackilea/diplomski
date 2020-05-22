public class MyClass
{
    private readonly IMessageService messageService;

    public MyClass(IMessageService messageService)
    {
        if(messageService == null)
        {
            throw new ArgumentNullException("messageService");
        }

        this.messageService = messageService;
    }

    public string GetMessage(int key)
    {
        return this.messageService.GetMessage(key)
    }
}