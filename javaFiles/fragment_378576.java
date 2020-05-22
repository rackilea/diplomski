public class IoThreadClientInvocationHandler implements InvocationHandler
{
  private final String TAG = Utils.getTag(IoThreadClientInvocationHandler.class);

  public static transient Boolean isMainFrame;
  private Object wrappedObject;

  public IoThreadClientInvocationHandler(Object wrappedObject)
  {
    this.wrappedObject = wrappedObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
  {
    // intercept invocation and store 'isMainFrame' argument
    if (method.getName().startsWith("shouldInterceptRequest") && args.length == 2)
    {
      String url = (String)args[0];
      isMainFrame = (Boolean)args[1];

      Log.d(TAG, "isMainFrame=" + isMainFrame + " for " + url);
    }
    return method.invoke(wrappedObject, args);
  }
}