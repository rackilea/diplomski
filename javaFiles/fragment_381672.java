BeanInfo info = Introspector.getBeanInfo(JTextField.class);
PropertyDescriptor[] propertyDescriptors =
                             info.getPropertyDescriptors();
for (int i = 0; i < propertyDescriptors.length; ++i) {
    PropertyDescriptor pd = propertyDescriptors[i];
    if (pd.getName().equals("text")) {
        pd.setValue("transient", Boolean.TRUE);
    }
}