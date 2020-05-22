public class B
{
    private Callback callbackoNotify;

    public class registerCallback(Callback callback)
    {
        callbackoNotify = callback;
    }

    public void notify()
    { 
        callbackNotify.call();
    }
}