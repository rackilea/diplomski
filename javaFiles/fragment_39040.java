public class MyCustomException extends Exception
{
    // To keep compiler happy about Exception being serializable.
    // Note: This should carry meaningful value when these exceptions are going 
    // to be serialized
    public static final long serialVersionUID = 1L; 

    public MyCustomException(String message, Throwable t)
    {
        super(message, t);
    }

    // Other constructors of interest from the super classes.
}