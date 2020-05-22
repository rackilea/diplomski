public class singleton
{
    private static singleton _obj;

    private singleton()
    {
        // prevents instantiation from external entities
    }

    // Instead of creating new operator, declare a method
    // and that will create object and return it.

    public static singleton GetObject()
    {
        // Check if the instance is null, then it
        // will create new one and return it.
        // Otherwise it will return previous one.

        if (_obj == null)
        {
            _obj = new singleton();
        }

        return _obj;
    }

}