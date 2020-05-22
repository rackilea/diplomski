private static void writeInLogger(Object obj, String str) {
    Class klazz = obj.getClass();
    if (klazz.isPrimitive() || obj instanceof String || obj instanceof Integer || obj instanceof Double
            || obj instanceof Boolean)
        System.out.println(str + obj.toString());
    else {
        try {
            for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(klazz).getPropertyDescriptors()) {
                if(propertyDescriptor.getWriteMethod() == null)
                    continue;
                Method m = propertyDescriptor.getReadMethod();
                if (m != null) {
                    Object object = m.invoke(obj);
                    if(object != null)
                        writeInLogger(object, str);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}