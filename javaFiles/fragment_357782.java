@SuppressWarnings("unchecked")
public static <T> T getInstance(String clazz) {
    // TODO check for clazz null
    try {
        return (T)Class.forName(clazz).getMethod("getInstance", (Class<?>[])null).invoke(null, (Object[])null);
    }
    catch (ClassNotFoundException cnfe) {
        // TODO handle
        return null;
    }
    catch (NoSuchMethodException nsme) {
        // TODO handle
        return null;
    }
    catch (InvocationTargetException ite) {
        // TODO handle
        return null;
    }
    catch (IllegalAccessException iae) {
        // TODO handle
        return null;
    }
}