try {
    throw new Exception();
}
catch (Exception e) {
    // Get the stack trace
    StackTraceElement[] entries = e.getStackTrace();
}