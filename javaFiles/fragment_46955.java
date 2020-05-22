private static Method getSetterMethod(Object o, Field f) {       
    for (Method method : o.getClass().getMethods()) {
        String fieldname = "set" + f.getName();
        String methodname = method.getName().toLowerCase();
        if (fieldname.equals(methodname)) {
            return method;
        }
    }
    return null;
}