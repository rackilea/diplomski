import javax.annotation.PostConstruct;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("services");
        post_construct();   // <-- here is the call
    }

    @PostConstruct
    public void post_construct () {
        //The method I want to run
    }
}