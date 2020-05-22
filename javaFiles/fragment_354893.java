public synchronized void insert(final byte[] send) {
    for (final Thread c : consumers) {
    try {
        Class<?> cls = Class.forName(c.getClass().getName());
        Method meth = cls.getMethod("add", new Class[]{byte[].class});
        meth.invoke(c, send);