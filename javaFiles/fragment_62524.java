public void invokeMethod() throws Throwable {
    // 1. Retrieves a Lookup
    MethodHandles.Lookup lookup = MethodHandles.lookup();

    // 2. Creates a MethodType
    MethodType methodType = MethodType.methodType(boolean.class, String.class);
    //                                            ^-----------^  ^----------^
    //                                             return type   argument class

    // 3. Find the MethodHandle
    MethodHandle handle = lookup.findVirtual(FooBar.class, "navigateToUrl", methodType);
    //                                       ^----------^  ^-------------^
    //                                            |        name of method
    //                             class from which method is accessed

    // 4. Invoke the method
    boolean b = (boolean) handle.invokeExact(fooBar, "test");
    //                                       ^----^  ^----^
    //                                          |    argument
    //                       instance of FooBar to invoke the method on

    System.out.println(b);
}