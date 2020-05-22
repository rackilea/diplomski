import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public void populateValues(Object bean, Map<String, Object> propertyValues) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    BeanInfo beanInfo = Introspector.getBeanInfo(Pojo.class);
    for(PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
        if(pd.getWriteMethod() != null && propertyValues.containsKey(pd.getName())) {
            pd.getWriteMethod().invoke(bean, propertyValues.get(pd.getName()));
        }
    }
}