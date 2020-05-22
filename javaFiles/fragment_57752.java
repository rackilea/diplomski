private final InvocationHandler invocationHandler = new InvocationHandler()
{
    @Override
    public Object invoke( Object proxy, Method method, Object[] arguments )
        throws Throwable
    {
        /* your pre-invocation code goes here */
        /* ... */

        /* invoke original object */
        Object result = method.invoke( myObject, arguments );

        /* your post-invocation code goes here */
        /* ... */

        /* return the result (will probably be null if method was void) */
        return result;
    }
};