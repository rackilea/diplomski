package mypackage.adapters;

import java.lang.reflect.Method;
import java.util.Vector;

import flex.messaging.services.remoting.RemotingDestination;
import flex.messaging.services.remoting.adapters.JavaAdapter;
import flex.messaging.util.MethodMatcher;

public class MyAdapter extends JavaAdapter {
    protected void saveInstance(Object instance) {
        try {
            MethodMatcher methodMatcher = ((RemotingDestination)getDestination()).getMethodMatcher();
            Method method = methodMatcher.getMethod(instance.getClass(), "destroy", new Vector());
            if ( method != null ) {
                method.invoke(instance);
            }
        }
        catch ( Exception ex ) {
            ex.printStackTrace(System.out);
        }

        super.saveInstance(instance);
    }
}