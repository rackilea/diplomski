public static void failTest(String message) throws MyTestFailure {
    System.err.println(message);
    MyTestFailure exception = new MyTestFailure(message);
    StackTraceElement elem = new StackTraceElement("com.my.package.Utils", "failTest", "failTest", 3);
    StackTraceElement elem1[] = new StackTraceElement[1];
    elem1[0] = elem;
    exception.setStackTrace(elem1);
    throw exception;
}