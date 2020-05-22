public class CustomDispatchProvider implements ResourceMethodDispatchProvider {

ResourceMethodDispatchProvider provider;

CustomDispatchProvider(ResourceMethodDispatchProvider provider)
{
    this.provider = provider;
}

@Override
public RequestDispatcher create(AbstractResourceMethod abstractResourceMethod) {
    System.out.println("creating new dispatcher for " + abstractResourceMethod);

    RequestDispatcher defaultDispatcher = provider.create(abstractResourceMethod);
    if (abstractResourceMethod.getMethod().isAnnotationPresent(Secure.class))
        return new DispatcherDecorator(defaultDispatcher);
    else
        return defaultDispatcher;
}

@Provider
public static class CustomDispatchAdapter implements ResourceMethodDispatchAdapter
{

    @Override
    public ResourceMethodDispatchProvider adapt(ResourceMethodDispatchProvider provider) {
        return new CustomDispatchProvider(provider);
    }

}

public static class DispatcherDecorator implements RequestDispatcher
{
    private RequestDispatcher dispatcher;

    DispatcherDecorator(RequestDispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    public void dispatch(Object resource, HttpContext context) {
        if (context.getRequest().isSecure())
        {
            System.out.println("secure request detected");
            this.dispatcher.dispatch(resource, context);
        }
        else
        {
            System.out.println("request is NOT secure");
            throw new RuntimeException("cannot access this resource over an insecure connection");
        }

    }

}
}