package stack;

public class ServiceFactory
{

/*
 * you can do it with factory and class reflection if the input is always the prefix for the service bean. 
 */
private static ServiceFactory instance;

// the package name where your service beans are
private final String serviceBeanPackage = "stack.";

private ServiceFactory()
{

}

public static ServiceFactory getInstance()
{
    if (instance == null)
    {
        instance = new ServiceFactory();
    }
    return instance;
}

@SuppressWarnings("unchecked")
public ServiceBeanInterface getServiceBean(String prefix)
{
    ServiceBeanInterface serviceBean = null;
    try
    {

        Class<ServiceBeanInterface> bean = (Class<ServiceBeanInterface>) Class
                .forName(serviceBeanPackage + prefix + "ServiceBean");

        serviceBean = bean.newInstance();
    }
    catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return serviceBean;

}

}