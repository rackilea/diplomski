Thread current = Thread.currentThread();
    StackTraceElement[] stack = current.getStackTrace();
    for(StackTraceElement element : stack)
    {
        if (!element.isNativeMethod()) {
            String className = element.getClassName();
            String fileName = element.getFileName();
            int lineNumber = element.getLineNumber();
            String methodName = element.getMethodName();
        }
    }