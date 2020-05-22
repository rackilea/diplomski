public static void main(String... args) {
if (args.length != 4) {
    err.format("Usage: java Deet <classname> <langauge> <country> <variant>%n");
    return;
}

try {
    Class<?> c = Class.forName(args[0]);
    Object t = c.newInstance();

    Method[] allMethods = c.getDeclaredMethods();
    for (Method m : allMethods) {
    String mname = m.getName();
    if (!mname.startsWith("test")
        || (m.getGenericReturnType() != boolean.class)) {
        continue;
    }
    Type[] pType = m.getGenericParameterTypes();
    if ((pType.length != 1)
        || Locale.class.isAssignableFrom(pType[0].getClass())) {
        continue;
    }

    out.format("invoking %s()%n", mname);
    try {
        m.setAccessible(true);
        Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
        out.format("%s() returned %b%n", mname, (Boolean) o);

    // Handle any exceptions thrown by method to be invoked.
    } catch (InvocationTargetException x) {
        Throwable cause = x.getCause();
        err.format("invocation of %s failed: %s%n",
               mname, cause.getMessage());
    }
    }

    // production code should handle these exceptions more gracefully
} catch (ClassNotFoundException x) {
    x.printStackTrace();
} catch (InstantiationException x) {
    x.printStackTrace();
} catch (IllegalAccessException x) {
    x.printStackTrace();
}
}