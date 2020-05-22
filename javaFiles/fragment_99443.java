private Condition<PropertyDescriptor> propertyOn(T bean, Description mismatch) {
    PropertyDescriptor property = PropertyUtil.getPropertyDescriptor(propertyName, bean);
    if (property != null) {
        if (property.getReadMethod() == null && property.getPropertyType().equals(Boolean.class)) {
            String booleanGetter = "is" propertyName.substring(0, 1).toUpperCase() propertyName.substring(1);
            for(Method method : bean.getClass().getDeclaredMethods()) {
                if (method.getName().equals(booleanGetter)) {
                    try {
                        property.setReadMethod(method);
                    } catch (IntrospectionException e) {
                        throw new IllegalStateException("Cannot set read method" e);
                    }
                }
            }
        }
    } else {
        mismatch.appendText("No property \"" + propertyName + "\"");
        return notMatched();
    }

    return matched(property, mismatch);
}