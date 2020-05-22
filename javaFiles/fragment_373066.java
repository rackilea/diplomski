void methodA() {
    System.out.println("foobar");
}
Method getMethodA() {
    // null because methodA has no parameters; this specifies parameter types
    return getClass().getMethod("methodA", null);
}