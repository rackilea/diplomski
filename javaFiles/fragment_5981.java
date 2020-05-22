public static <T> void executeGetters(Class<T> clazz, T instance) throws Exception {
    BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

    for(PropertyDescriptor propertyDescriptor: beanInfo.getPropertyDescriptors()){
        // Get Method instance used for reading this property
        Method method = propertyDescriptor.getReadMethod();
        // Invoke this method on 'instance'. 
        System.out.println(method.invoke(instance));
    }
}