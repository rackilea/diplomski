public static Throwable shortThrowable(Throwable ex) {
    return ex instanceOf InvocationTargetException? ex.getCause() : ex;
}

...
catch (Exception ex) {
    shortThrowable(ex).printStackTrace(); // Or better logging.
}