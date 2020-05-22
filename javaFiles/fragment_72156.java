import java.beans.Introspector;
import java.beans.PropertyDescriptor;


...
String name = "age";
Class beanClass = Student.class;
BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
for (PropertyDescriptor descriptor : descriptors) {
    if (!name.equals(descriptor.getName())) {
        continue;
    }
    descriptor.getWriteMethod();
    descriptor.getReadMethod()
}