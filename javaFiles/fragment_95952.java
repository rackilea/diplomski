public class Foo
{
    public void setBar()
    {
        throw new UnsupportedOperationException("should not go here");
    }

    public void redirected()
    {
        System.out.println("Yiha");
    }
}

Foo foo = new Foo();
ProxyFactory pf = new ProxyFactory(foo);

pf.addAdvice(new MethodInterceptor()
{
    public Object invoke(MethodInvocation mi) throws Throwable
    {
        if (mi.getMethod().getName().startsWith("set"))
        {
            Method redirect = mi.getThis().getClass().getMethod("redirected");
            redirect.invoke(mi.getThis());
        }
        return null;
    }
});

Foo proxy = (Foo) pf.getProxy();
proxy.setBar(); // prints "Yiha"