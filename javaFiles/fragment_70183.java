public static Object getProperty(Object bean, String propertyName) {
    BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
    PropertyDescriptor propertyDescriptor = Arrays
            .stream(beanInfo.getPropertyDescriptors())
            .filter(pd -> pd.getName().equals(propertyName)).findFirst()
            .get();
    return propertyDescriptor.getReadMethod().invoke(bean);
}