String result1, result2;
Thread thread = Thread.currentThread();
ClassLoader myLoader = thread.getContextClassLoader();
try {
    thread.setContextClassLoader(v1Loader);
    result1 = (String) runMethod1.invoke(engine1);
    thread.setContextClassLoader(v2Loader);
    result2 = (String) runMethod2.invoke(engine2);
} finally {
    thread.setContextClassLoader(myLoader);
}
// Compare result1 and result2