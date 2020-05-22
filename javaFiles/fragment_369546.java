public class NativeTagCallback : TagCallback
{
    protected long      cppCallbackPtr;

    public NativeTagCallback( long callbackPtr )
    {
        cppCallbackPtr = callbackPtr;
    }

    public native void NativeCallback( long callbackPtr, int arg0, String arg1, Set<String> arg2 );

    public void callback(int arg0, String arg1, Set<String> arg2) 
    {
        NativeCallback( cppCallbackPtr, arg0, arg2, arg2 );
    }
}