public class AuthenticationFactoryDecorator implements AuthFactory {

    private AuthFactory authenticationFactoryDelegate;

    private MethodInterceptor interceptor;

    public AuthenticationFactoryDecorator( final AuthFactory authenticationFactoryDelegate, final MethodInterceptor interceptor )
    {
        this.authenticationFactoryDelegate = authenticationFactoryDelegate;
        this.interceptor = interceptor;
    }

    @Override
    public Authenticator create()
    {
         // Create the needed pointcut
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("authenticate");
        // Get an authenticator from your legacy class
        Authenticator auth = authenticationFactoryDelegate.create();
        // Create a new Proxy wrapping your authFactory with the needed pointcut and advice
        ProxyFactory proxyFactory = new ProxyFactory(auth);
        proxyFactory.addAdvice(interceptor);
        return (Authenticator) proxyFactory.getProxy();
    }
}