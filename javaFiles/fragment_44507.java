PropertyDescriptor[] propertyDescriptors = 
    Introspector.getBeanInfo(beanClass).getPropertyDescriptors();
List<String> propertyNames = new ArrayList<String>(propertyDescriptors.length);
for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
    propertyNames.add(propertyDescriptor.getName());
}