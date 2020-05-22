static Class<?> getOutermostClass(Class<?> clazz) {
    while (clazz.getEnclosingClass() != null) {
        clazz = clazz.getEnclosingClass();
    }
    return clazz;
}

public static writeLogMessagesForFoo(IFoo somefoo) {
    Logger logger = LoggerFactory.getLogger(getOutermostClass(somefoo.getClass()));
}