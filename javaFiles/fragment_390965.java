public class LoggingInterceptor {
    ...
    @AroundInvoke
    protected Object myInterceptor(InvocationContext ctx) throws Exception {
        //do logging here...
        return ctx.proceed();
    }
}

@Interceptors(LoggingInterceptor.class)
public class SomeBean implements MessageListener {
    public void onMessage(Message message) {
        //....
    }
}