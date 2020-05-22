public static ClientLogger getInstance(final Class<?> klass) {
    ClientLogger result = s_classLoggers.get(klass);
    if (result != null) 
        return result; // fast path

    // slow, but rare path
    synchronized (s_classLoggers) {
        result = s_classLoggers.get(klass);
        if (result == null)
            s_classLoggers.put(klass, result = new ClientLogger(klass));
    }
    return result;
}