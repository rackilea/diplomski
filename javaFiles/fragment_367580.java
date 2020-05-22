static class SomeClass {
    public void someMethod(Object arg) {
        System.out.println("test" + arg);
    }
}


static Consumer<Object> findConsumer(SomeClass instance) {
    try {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);

        return (Consumer<Object>) LambdaMetafactory.metafactory(
                lookup,
                "accept",
                MethodType.methodType(Consumer.class, SomeClass.class),
                methodType,
                lookup.findVirtual(SomeClass.class, "someMethod", methodType),
                methodType)
                .getTarget()
                .invokeExact(instance);
    } catch (Throwable t) {
        t.printStackTrace();
        throw new RuntimeException();
    }
}