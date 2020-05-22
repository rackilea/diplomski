/**
 * Return a new subclass of the Foo class.
 */
public Foo fooFactory(Class<? extends Foo> c)
{
    Foo instance = null;
    try {
        instance = c.newInstance();
    }
    catch (InstantiationException e) {
        // ...
    }
    catch (IllegalAccessException e) {
        // ...
    }
    return instance; // which might be null if exception occurred,
                     // or you might want to throw your own exception
}