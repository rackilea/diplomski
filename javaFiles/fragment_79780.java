import java.lang.reflect.Field;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.MethodParameter;

public class CustomBeanFactory extends DefaultListableBeanFactory {

    public CustomBeanFactory() {
    }

    public CustomBeanFactory(DefaultListableBeanFactory delegate) {
        super(delegate);
    }

    @Override
    public Object resolveDependency(DependencyDescriptor descriptor,
            String beanName, Set<String> autowiredBeanNames,
            TypeConverter typeConverter) throws BeansException {
        //Assign Logger parameters if required      
        if (Logger.class == descriptor.getDependencyType()) {            
            return LoggerFactory.getLogger(getDeclaringClass(descriptor));
        } else {
            return super.resolveDependency(descriptor, beanName,
                    autowiredBeanNames, typeConverter);
        }
    }

    private Class<?> getDeclaringClass(DependencyDescriptor descriptor) {
        MethodParameter methodParameter = descriptor.getMethodParameter();
        if (methodParameter != null) {
            return methodParameter.getDeclaringClass();
        }
        Field field = descriptor.getField();
        if (field != null) {
            return field.getDeclaringClass();
        }
        throw new AssertionError("Injection must be into a method parameter or field.");
    }
}