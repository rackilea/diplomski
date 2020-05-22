public class MyClass
{
    public string GetMessage(int key)
    {
        return new MessageService().GetMessage(key)
    }
}