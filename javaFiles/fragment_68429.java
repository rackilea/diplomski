StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

    // The 2nd element of the array is the current method
    String className = stackTrace[1].getClassName();
    Class clazz = Class.forName(stackTrace[1].getClassName());

    String methodName = stackTrace[1].getClassName()+"."+stackTrace[1].getMethodName();
    String simpleMethodName = stackTrace[1].getMethodName();

    // This will work only when there are no parameters for the method
    Method m = clazz.getDeclaredMethod(simpleMethodName, null);

    // Fetch the annotations 
    Annotation[] annotations = m.getDeclaredAnnotations();