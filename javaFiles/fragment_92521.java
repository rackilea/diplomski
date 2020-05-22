import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class TestComponent implements Callable {

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        // This is how you access a property
        String httpMethod = eventContext.getMessage().getProperty("http.method", PropertyScope.INBOUND);
        System.out.println("The value of property name is >>>" + httpMethod);

        // This is how you access flow variable
        String name = eventContext.getMessage().getInvocationProperty("name");
        System.out.println("The value of property name is >>>" + name);
        return name + " > " + httpMethod;
    }

}