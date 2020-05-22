public class HandlerFactory extends SecondHandlerFactory
{
    public InterfaceExample createSomethingByThisKey(String key) throws HandlerCreationException
    {
        InterfaceExample myNewHandler = null;

        if (StringFunctions.isEqualIgnoreCase(key, "Phone"))
        {
            myNewHandler = new PhoneHandler();
        }
    }
}