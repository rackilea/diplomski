import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import jetty.plugin.test.domain.MyObject;
import org.glassfish.hk2.api.Factory;

public class MyObjectFactory implements Factory<MyObject> {

    private final ContainerRequestContext context;

    @Inject
    public MyObjectFactory(ContainerRequestContext context) {
        this.context = context;
    }

    @Override
    public MyObject provide() {
        return (MyObject)context.getProperty("myObject");
    }

    @Override
    public void dispose(MyObject t) {}  
}