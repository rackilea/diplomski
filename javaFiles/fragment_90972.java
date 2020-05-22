import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;

public class MainActivity
{
  public static void main(String[] args)
  {
    Provider [] providerList = Security.getProviders();
    for (Provider provider : providerList)
     {
       System.out.println("Name: "  + provider.getName());
       System.out.println("Information:\n" + provider.getInfo());

       Set<Service> serviceList = provider.getServices();
       for (Service service : serviceList)
        {
          System.out.println("Service Type: " + service.getType() + " Algorithm " + service.getAlgorithm());
        }
     }
  }
}