package resource;

import javax.ws.rs.ext.Provider;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import java.lang.reflect.Type;

@Provider
public class MyResourceProvider implements InjectableProvider<MyResource, Type> {

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable getInjectable(final ComponentContext arg0, final MyResource arg1, final Type arg2) {
        if (Integer.class.equals(arg2)) {
            return new Injectable<Integer>() {

                @Override
                public Integer getValue() {
                    return new Integer(99);
                }
            };
        } else {
            return null;
        }
    }
}