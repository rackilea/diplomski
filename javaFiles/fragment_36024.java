public Object functionName(String variableName, Object valueToBeSet, Object objectOfClass) throws IntrospectionException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

        //I want to do the exact same thing as it does when setting the value using the below statement
        //objectOfClass.setX(valueToBeSet);
        Class clazz = objectOfClass.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class); // get bean info
        PropertyDescriptor[] props = beanInfo.getPropertyDescriptors(); // gets all info about all properties of the class.
        for (PropertyDescriptor descriptor : props) {
            String property = descriptor.getDisplayName();
            if(property.equals(variableName)) {
                String setter = descriptor.getWriteMethod().getName();
                Class parameterType = descriptor.getPropertyType();
                Method setterMethod = clazz.getDeclaredMethod(setter, parameterType); //Using Method Reflection
                setterMethod.invoke(objectOfClass, valueToBeSet);
            }

        }

    return objectOfClass;
    }