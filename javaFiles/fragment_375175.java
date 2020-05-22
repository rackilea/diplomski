public class AuthenticationAdvise implements MethodInterceptor
{
    @Override
    public Object invoke( MethodInvocation methodInvocation ) throws Throwable
    {
        System.out.println("Before invocation..."); // Your advice logic goes here
        return methodInvocation.proceed();
    }
}