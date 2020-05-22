public class MyClass
{
    /**
     * Create the only one instance of this class.
     */
    private static final MyClass sInstane = new MyClass();

    /**
     * This is the only one constructor in this class.
     * Because this is 'private', no others can create
     * instances of this class.
     */
    private MyClass()
    {
    }

    /**
     * Get the only one instance of this class.
     */
    public static MyClass getInstance()
    {
        return sInstance;
    }
}