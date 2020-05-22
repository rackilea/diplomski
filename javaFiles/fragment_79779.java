import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

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
        if (descriptor.isRequired()
                && Logger.class.isAssignableFrom(descriptor
                        .getMethodParameter().getParameterType())) {            
            return LoggerFactory.getLogger(descriptor.getMethodParameter()
                    .getDeclaringClass());
        } else {
            return super.resolveDependency(descriptor, beanName,
                    autowiredBeanNames, typeConverter);
        }
    }
}