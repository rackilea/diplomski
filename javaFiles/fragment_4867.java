import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.el.SimpleSpringBeanELResolver;

import javax.el.ELContext;
import javax.el.ELException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Resolves bean properties defined as default interface methods for the ELResolver.
 * Retains default SimpleSpringBeanELResolver for anything which isn't a default method.
 *
 * Created by nstuart on 12/2/2016.
 */
public class DefaultMethodELResolver extends SimpleSpringBeanELResolver {
    /**
     * @param beanFactory the Spring BeanFactory to delegate to
     */
    public DefaultMethodELResolver(BeanFactory beanFactory) {
        super(beanFactory);
    }

    @Override
    public Object getValue(ELContext elContext, Object base, Object property) throws ELException {

        if(base != null && property != null) {
            String propStr = property.toString();
            if(propStr != null) {
                Optional<Object> ret = attemptDefaultMethodInvoke(base, propStr);
                if (ret != null) {
                    // notify the ELContext that our prop was resolved and return it.
                    elContext.setPropertyResolved(true);
                    return ret.get();
                }
            }
        }

        // delegate to super
        return super.getValue(elContext, base, property);
    }

    /**
     * Attempts to find the given bean property on our base object which is defined as a default method on an interface.
     * @param base base object to look on
     * @param property property name to look for (bean name)
     * @return null if no property could be located, Optional of bean value if found.
     */
    private Optional<Object> attemptDefaultMethodInvoke(Object base, String property) {
        try {
            // look through interfaces and try to find the method
            for(Class<?> intf : base.getClass().getInterfaces()) {
                // find property descriptor for interface which matches our property
                Optional<PropertyDescriptor> desc = Stream.of(PropertyUtils.getPropertyDescriptors(intf))
                        .filter(d->d.getName().equals(property))
                        .findFirst();

                // ONLY handle default methods, if its not default we dont handle it
                if(desc.isPresent() && desc.get().getReadMethod() != null && desc.get().getReadMethod().isDefault()) {
                    // found read method, invoke it on our object.
                    return Optional.ofNullable(desc.get().getReadMethod().invoke(base));
                }
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Unable to access default method using reflection", e);
        }

        // no value found, return null
        return null;
    }

}