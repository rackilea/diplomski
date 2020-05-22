import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestletApplication extends ServerResource {
    @Get
    public String present() {
        return "hello, world";
    }

    public static void main(String... args) throws Exception {
        new ClassPathXmlApplicationContext("restlet-context.xml").registerShutdownHook();
    }
}