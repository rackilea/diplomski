public static void main(String[] args) {
    final String className = "com.my.package." + args[0];
    try {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod("say");
        Object object = clazz.newInstance();
        method.invoke(object);
    } catch (ClassNotFoundException e) {
        System.err.println("Error: No such class exists");
    } catch (SecurityException e) {
        System.err.println("Error: You are not allowed to do that");
    } catch (NoSuchMethodException e) {
        System.err.println("Error: No such method exists");
    } catch (InstantiationException e) {
        System.err.println("Error: Unable to instantiate");
    } catch (IllegalAccessException e) {
        System.err.println("Error: No access to class definition");
    } catch (IllegalArgumentException e) {
        System.err.println("Error: Illegal argument");
    } catch (InvocationTargetException e) {
        System.err.println("Error: Bad target");
    }
}