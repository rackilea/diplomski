public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Class<?> cls = Class.forName("pkg1.pkg2.classname");
    Method meth = cls.getMethod("main", String[].class);
    String[] params = null; // init params accordingly
    meth.invoke(null, (Object) params); // static method doesn't have an instance
}