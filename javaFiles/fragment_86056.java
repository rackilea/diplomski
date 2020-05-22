public int foo() {
    return 0;
}

...

Method method = someClass.getDeclaredMethod("foo");
Class<?> clazz = method.getReturnType();