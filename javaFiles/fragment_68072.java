package atata;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class EmployeeApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public EmployeeApplication() {
        singletons.add(new MessageRestService());
        singletons.add(new _404Handler());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}