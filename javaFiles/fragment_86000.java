package resource;

import javax.ws.rs.ext.Provider;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.PerRequestTypeInjectableProvider;

@Provider
public class MyResourceProvider extends PerRequestTypeInjectableProvider<MyResource, Integer> {
    public MyResourceProvider() {
        super(Integer.class);
    }

    @Override
    public Injectable<Integer> getInjectable(ComponentContext ic, MyResource a) {
        return new Injectable<Integer>() {
            @Override
            public Integer getValue() {
                return new Integer(99);
            }
        };
    }
}