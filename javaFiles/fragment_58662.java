@Foo @Interceptor
public class FooInterceptor
{
    @AroundInvoke
    public Object handleFoo(InvocationContext joinPoint) throws Exception
    {
        Method m = joinPoint.getMethod();

        // you can access all annotations on your @Foo-annotated method,
        // not just the @Foo annotation.
        Annotation[] as = m.getDeclaredAnnotations();

        // do stuff before the method call
        ...

        try
        {
            // here you call the actual method
            return joinPoint.proceed();
        }
        finally
        {
            // do stuff after the method call
            ...
        }
    }
}