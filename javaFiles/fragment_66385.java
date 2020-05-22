for (PropertyDescriptor descriptor : Introspector
        .getBeanInfo(TestBean.class, Object.class)
        .getPropertyDescriptors()) {
    System.out.println("Name: " + descriptor.getName() + 
                     ", type: " + descriptor.getPropertyType());
}