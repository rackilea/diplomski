BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
for(PropertyDescriptor pd : descriptors)
{
    if(pd.getName().equals(propertyName)
    {
        return pd.getReadMethod().invoke(bean, (Object[])null);
    }
}