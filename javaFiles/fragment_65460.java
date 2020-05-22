for(PropertyDescriptor propertyDescriptor : 
Introspector.getBeanInfo(User.class,Object.class).getPropertyDescriptors()){
    try {
        Object value = propertyDescriptor
                       .getReadMethod()

               .invoke(myUserInstance, (Object[])null);      
    }
    catch (IllegalAccessException iae) {
        // TODO
    }
    catch (IllegalArgumentException iaee) {
        // TODO
    }
    catch (InvocationTargetException ite) {
        // TODO
    }
}